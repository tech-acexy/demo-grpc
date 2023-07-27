package main

import (
	"context"
	"demo.grpc/pb/user"
	"fmt"
	"google.golang.org/grpc"
	"net"
	"strconv"
	"sync"
)

var once sync.Once

type UserServiceImpl struct {
	pbuser.UnimplementedUserServiceServer
}

func (*UserServiceImpl) QueryById(ctx context.Context, request *pbuser.Request) (*pbuser.Response, error) {
	fmt.Println("Get Input UserId " + strconv.FormatUint(request.Id, 10))
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
		fmt.Println("server started lis 5645")
		_ = server.Serve(lis)
	})
}
