package cn.acexy.tech.grpc;


import cn.acexy.tech.grpc.pb.user.Request;
import cn.acexy.tech.grpc.pb.user.Response;
import cn.acexy.tech.grpc.pb.user.UserServiceGrpc;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import org.junit.jupiter.api.Test;

public class GrpcClientTest {

    private String golangPort = "5645";
    private String javaPort = "5678";


    private UserServiceGrpc.UserServiceBlockingStub userService(String port) {
        ManagedChannel channel = Grpc.newChannelBuilder("localhost:" + port, InsecureChannelCredentials.create()).build();
        return UserServiceGrpc.newBlockingStub(channel);
    }

    @Test
    public void callServer() {
        Response response = userService(golangPort).queryById(Request.newBuilder().setId(321L).build());
        System.out.println(response.toString());
        response = userService(javaPort).queryById(Request.newBuilder().setId(321L).build());
        System.out.println(response.toString());
    }
}
