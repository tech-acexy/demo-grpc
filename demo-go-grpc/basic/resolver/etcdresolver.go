package resolver

import (
	"context"
	"fmt"
	client "go.etcd.io/etcd/client/v3"
	"go.etcd.io/etcd/client/v3/naming/endpoints"
	"google.golang.org/grpc/codes"
	gResolver "google.golang.org/grpc/resolver"
	"google.golang.org/grpc/status"
	"sync"
)

const EtcdScheme = "etcd"

type etcdBuilder struct {
	c *client.Client
}

func (b etcdBuilder) Build(target gResolver.Target, cc gResolver.ClientConn, opts gResolver.BuildOptions) (gResolver.Resolver, error) {
	r := &resolver{
		c:      b.c,
		target: target.Endpoint(),
		cc:     cc,
	}
	r.ctx, r.cancel = context.WithCancel(context.Background())

	em, err := endpoints.NewManager(r.c, r.target)
	if err != nil {
		return nil, status.Errorf(codes.InvalidArgument, "resolver: failed to new endpoint manager: %s", err)
	}
	r.wch, err = em.NewWatchChannel(r.ctx)
	if err != nil {
		return nil, status.Errorf(codes.Internal, "resolver: failed to new watch channer: %s", err)
	}

	r.wg.Add(1)
	go r.watch()
	return r, nil
}

func (b etcdBuilder) Scheme() string {
	return EtcdScheme
}

type resolver struct {
	c      *client.Client
	target string
	cc     gResolver.ClientConn
	wch    endpoints.WatchChannel
	ctx    context.Context
	cancel context.CancelFunc
	wg     sync.WaitGroup
}

func (r *resolver) watch() {
	defer r.wg.Done()

	allUps := make(map[string]*endpoints.Update)
	for {
		select {
		case <-r.ctx.Done():
			return
		case ups, ok := <-r.wch:
			if !ok {
				return
			}

			for _, up := range ups {
				switch up.Op {
				case endpoints.Add:
					allUps[up.Key] = up
				case endpoints.Delete:
					delete(allUps, up.Key)
				}
			}

			addresses := convertToGRPCAddress(allUps)
			_ = r.cc.UpdateState(gResolver.State{Addresses: addresses})
		}
	}
}

func convertToGRPCAddress(ups map[string]*endpoints.Update) []gResolver.Address {
	var addrs []gResolver.Address
	for _, up := range ups {
		addr := gResolver.Address{
			Addr: up.Endpoint.Addr,
		}
		addrs = append(addrs, addr)
	}
	return addrs
}

// ResolveNow is a no-op here.
// It's just a hint, resolver can ignore this if it's not necessary.
func (r *resolver) ResolveNow(gResolver.ResolveNowOptions) {}

func (r *resolver) Close() {
	r.cancel()
	r.wg.Wait()
}

type Etcd struct {
	EtcdUrls []string
}

func (e Etcd) NewResolver() (gResolver.Builder, error) {
	etcdClient, err := client.NewFromURLs(e.EtcdUrls)
	if err != nil {
		fmt.Printf("%+v\n", err)
	}
	return etcdBuilder{c: etcdClient}, nil
}
