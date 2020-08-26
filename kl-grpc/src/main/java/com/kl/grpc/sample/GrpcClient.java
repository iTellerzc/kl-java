package com.kl.grpc.sample;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc (000601)
 * @date 2020/8/25 20:30
 * description:
 **/
public class GrpcClient {

    private  ManagedChannel channel;

    private  GreeterGrpc.GreeterBlockingStub blockingStub;

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     */
    public GrpcClient(String host, int port) {

        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Say hello to server.
     */
    public void greet(String content) {

        SampleGrpc.SampleReq sampleReq = SampleGrpc.SampleReq.newBuilder().setContent(content).build();
        SampleGrpc.SampleResp sampleResp;
        try {
            sampleResp = blockingStub.sayHi(sampleReq);
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: {0}"+ e.getStatus());
            return;
        }
        System.out.println(("Greeting: " + sampleResp.getResp()));
    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception {
        GrpcClient client = new GrpcClient("localhost", 50051);
        try {
            client.greet("hello, iTeller_zc, this is java client!");
        } finally {
            client.shutdown();
        }
    }
}
