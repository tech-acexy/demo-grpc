package cn.acexy.tech.grpc.demo.simple.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientDemo {

    static ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",9981).usePlaintext().build();

    public static void main(String[] args) {

    }
}
