package client

import (
	"context"
	"demo.grpc/pb/user"
	"encoding/json"
	"fmt"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
	"testing"
	"time"
)

func TestClient(t *testing.T) {
	conn, _ := grpc.Dial("127.0.0.1:5645", grpc.WithTransportCredentials(insecure.NewCredentials()))
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
