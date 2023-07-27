package main

import (
	"context"
	"demo.grpc/pb/user"
	"google.golang.org/grpc"
	"net"
	"sync"
)

var once sync.Once

type UserServiceImpl struct {
	pbuser.UnimplementedUserServiceServer
}

func (*UserServiceImpl) QueryById(context.Context, *pbuser.Request) (*pbuser.Response, error) {
	return &pbuser.Response{
		Users: []*pbuser.User{{
			Name: "maacsek",
		}},
	}, nil
}

func main() {
	once.Do(func() {
		server := grpc.NewServer()
		pbuser.RegisterUserServiceServer(server, &UserServiceImpl{})
		lis, _ := net.Listen("tcp", ":5645")
		_ = server.Serve(lis)
	})
}
