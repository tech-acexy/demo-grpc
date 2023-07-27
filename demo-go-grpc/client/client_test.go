package client

import (
	"context"
	pbuser "demo.grpc/pb/user"
	"encoding/json"
	"fmt"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
	"testing"
	"time"
)

const (
	golangPort = "5645"
	javaPort   = "5678"
)

func callServer(port string) {
	conn, _ := grpc.Dial("127.0.0.1:"+port, grpc.WithTransportCredentials(insecure.NewCredentials()))
	defer conn.Close()
	userService := pbuser.NewUserServiceClient(conn)

	ctx, cancel := context.WithTimeout(context.Background(), time.Second)
	defer cancel()
	user, err := userService.QueryById(ctx, &pbuser.Request{Id: 123})
	if err != nil {
		return
	}

	bytes, err := json.Marshal(user)
	fmt.Println(string(bytes))
}

func TestClient(t *testing.T) {
	callServer(golangPort)
	callServer(javaPort)
}
