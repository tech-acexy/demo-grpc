# PROTO_BIN_PATH := /Users/acexy/Repository/cache/golang/project/demo-go-grpc/bin
# export PATH := $(PROTO_BIN_PATH):${PATH}

default: all
	protoc --version

all: java

java:
	protoc --java_out=src/main/java ./pb/user/user.proto