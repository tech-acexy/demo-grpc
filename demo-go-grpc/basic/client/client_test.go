package client

import (
	"context"
	"demo.grpc/basic/resolver"
	pbuser "demo.grpc/pb/user"
	"encoding/json"
	"fmt"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
	"google.golang.org/grpc/status"
	"os"
	"os/signal"
	"syscall"
	"testing"
	"time"
)

var userService pbuser.UserServiceClient

func useStaticResolver() (*Conn, error) {
	return NewClientConn(
		resolver.StaticScheme+":///user",
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

func useEtcdResolver() (*Conn, error) {
	return NewClientConn(
		resolver.EtcdScheme+":///user",
		resolver.Etcd{EtcdUrls: []string{"http://localhost:2379"}},
		true,
		grpc.WithTransportCredentials(insecure.NewCredentials()),
		grpc.WithDefaultServiceConfig(`{"loadBalancingPolicy":"round_robin"}`),
	)
}

func userCall(userService pbuser.UserServiceClient) {
	ctx, cancel := context.WithTimeout(context.Background(), 10*time.Second)
	defer cancel()
	user, err := userService.QueryById(ctx, &pbuser.Request{Id: 123})
	if err != nil {
		statusError := status.Convert(err)
		fmt.Printf("%+v\n", statusError.Code())
		fmt.Printf("QueryById Error %T %+v\n", err, err)
		return
	}
	bytes, err := json.Marshal(user)
	fmt.Println(string(bytes))
}

func doRequest(ctx context.Context, conn *Conn) {
	userService = pbuser.NewUserServiceClient(conn.gCon)
	go func() {
		for {
			userCall(userService)
			time.Sleep(time.Second)
			select {
			case <-ctx.Done():
				//_ = conn.CloseGCon()
				break
			default:

			}
		}
	}()
}

func TestStaticClient(t *testing.T) {
	conn, err := useStaticResolver()
	if err != nil {
		fmt.Printf("%+v\n", err)
		return
	}
	ctx, cancel := context.WithCancel(context.Background())
	doRequest(ctx, conn)
	sigChan := make(chan os.Signal, 1)
	signal.Notify(sigChan, syscall.SIGINT, syscall.SIGTERM)
	<-sigChan
	cancel()
}

func TestEtcdClient(t *testing.T) {
	ctx, cancel := context.WithCancel(context.Background())
	defer cancel()

	go func() {
		time.Sleep(time.Second * 5)
		fmt.Println("register new instance")
		_ = resolver.RegisterEtcdInstance(ctx, "user", "1", "localhost:5678", 3)
		time.Sleep(time.Second * 15)
		fmt.Println("stop instance keepalive")
		cancel()
	}()

	conn, err := useEtcdResolver()
	if err != nil {
		fmt.Printf("%+v\n", err)
		return
	}

	doRequest(ctx, conn)

	sigChan := make(chan os.Signal, 1)
	signal.Notify(sigChan, syscall.SIGINT, syscall.SIGTERM)
	<-sigChan

	// 可以等待相关程序停止的回执再退出主程序
}
