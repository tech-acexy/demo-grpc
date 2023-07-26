- 安装protocol buffer协议编译插件

    ```
    go install google.golang.org/protobuf/cmd/protoc-gen-go@v1.28
    
    go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@v1.2
  
    brew install protobuf
    ```

- 运行插件

  ```
  `go env GOPATH | cut -d ':' -f1`/pkg/bin/protoc 
  ```