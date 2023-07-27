package cn.acexy.tech.grpc.pb.impl.user;

import cn.acexy.tech.grpc.pb.user.*;
import io.grpc.stub.StreamObserver;

public class UserProtoImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void queryById(Request request, StreamObserver<Response> responseObserver) {
        System.out.println("Get Input UserId " + request.getId());
        responseObserver.onNext(Response.newBuilder().addUsers(User.newBuilder().setName("jaidegogogo").build()).build());
        responseObserver.onCompleted();
    }
}
