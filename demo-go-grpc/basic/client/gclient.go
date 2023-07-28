package client

import (
	"demo.grpc/basic/resolver"
	"google.golang.org/grpc"
	"google.golang.org/grpc/connectivity"
	"log"
	"time"
)

type Conn struct {
	gCon *grpc.ClientConn
}

func (g *Conn) GetGCon() *grpc.ClientConn {
	return g.gCon
}

func (g *Conn) CloseGCon() error {
	return g.gCon.Close()
}

func (g *Conn) IsConReady() bool {
	state := g.GetState()
	if state != connectivity.Ready {
		return false
	}
	return true
}

func (g *Conn) GetState() connectivity.State {
	return g.gCon.GetState()
}

func NewClientConn(target string, iResolver resolver.IResolver, waitCoonToReady bool, opts ...grpc.DialOption) (*Conn, error) {

	gResolver, err := iResolver.NewResolver()

	if err != nil {
		return nil, err
	}

	if len(opts) == 0 {
		opts = make([]grpc.DialOption, 1)
		opts[0] = grpc.WithResolvers(gResolver)
	} else {
		opts = append(opts, grpc.WithResolvers(gResolver))
	}

	con, err := grpc.Dial(target, opts...)
	if err != nil {
		return nil, err
	}

	c := &Conn{
		gCon: con,
	}

	if waitCoonToReady {
		log.Println("waitCoonToReady = true, check conn state")
		if !c.IsConReady() {
			i := 0
			for !c.IsConReady() {
				if i <= 10 {
					log.Println("conn state not ready, wait to be ready")
					// still wait conn state to be ready
					if c.IsConReady() {
						break
					}
				} else {
					_ = c.gCon.Close()
					log.Println("released old conn get new conn")
					// get new conn
					con, err = grpc.Dial(target, opts...)
					if err != nil {
						return nil, err
					}
					c.gCon = con
					i = -1
				}
				i++
				time.Sleep(2 * time.Second)
			}
		}
	}
	return c, nil
}
