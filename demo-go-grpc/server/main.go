package main

import (
	"context"
	"demo.grpc/proto"
	"google.golang.org/grpc"
	"net"
	"sync"
)

var once sync.Once

type UserServiceImpl struct {
	proto.UnimplementedUserServiceServer
}

func (*UserServiceImpl) QueryById(context.Context, *proto.Request) (*proto.Response, error) {
	return &proto.Response{
		Users: []*proto.User{{
			Name: "maacsek",
		}},
	}, nil
}

func main() {
	once.Do(func() {
		server := grpc.NewServer()
		proto.RegisterUserServiceServer(server, &UserServiceImpl{})
		lis, _ := net.Listen("tcp", ":5645")
		_ = server.Serve(lis)
	})
}
