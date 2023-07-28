package client

import (
	"context"
	resolver "demo.grpc/basic/resolver"
	pbuser "demo.grpc/pb/user"
	"encoding/json"
	"fmt"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
	"testing"
	"time"
)

var userService pbuser.UserServiceClient

func useStaticResolver() (*Conn, error) {
	return NewClientConn(
		resolver.StaticScheme+"///user",
		resolver.Static{Addresses: map[string][]string{
			"user": {
				"127.0.0.1:5645",
				"127.0.0.1:5678",
			},
		}},
		true,
		grpc.WithTransportCredentials(insecure.NewCredentials()),
		grpc.WithDefaultServiceConfig(`{"loadBalancingPolicy":"round_robin"}`),
	)
}

func useEtcdResolver() (*grpc.ClientConn, error) {

	var iResolver resolver.IResolver

	iResolver = resolver.Etcd{
		EtcdUrls: []string{"http://localhost:2379"},
	}

	etcdResolver, err := iResolver.NewResolver()

	if err != nil {
		fmt.Printf("%+v\n", err)
		return nil, nil
	}

	return grpc.Dial(
		"etcd:///service/user",
		grpc.WithTransportCredentials(insecure.NewCredentials()),
		grpc.WithResolvers(etcdResolver),
	)

}

func callServer() {
	coon, err := useStaticResolver()
	userService = pbuser.NewUserServiceClient(coon.gCon)

	//defer conn.Close()
	ctx, cancel := context.WithTimeout(context.Background(), 10*time.Second)
	defer cancel()
	user, err := userService.QueryById(ctx, &pbuser.Request{Id: 123})
	if err != nil {
		fmt.Printf("QueryById %+v\n", err)
		return
	}
	bytes, err := json.Marshal(user)
	fmt.Println(string(bytes))
}

func TestClient(t *testing.T) {

	go func() {
		for i := 1; i <= 100; i++ {
			callServer()
			time.Sleep(time.Second)
		}
	}()

	time.Sleep(time.Hour)
}
