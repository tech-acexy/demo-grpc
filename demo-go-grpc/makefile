PROTO_BIN_PATH := /Users/acexy/Repository/cache/golang/project/demo-go-grpc/bin
export PATH := $(PROTO_BIN_PATH):${PATH}

default: all
	protoc --version

all: golang


golang:
	protoc --go_out=. --go_opt=paths=source_relative \
    		--go-grpc_out=. --go-grpc_opt=paths=source_relative \
    		--validate_out="lang=go,paths=source_relative:." \
    		./pb/user/user.proto \