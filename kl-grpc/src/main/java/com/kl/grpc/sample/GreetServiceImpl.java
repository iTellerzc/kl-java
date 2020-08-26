package com.kl.grpc.sample;

import io.grpc.stub.StreamObserver;

/**
 * @author iTeller_zc (000601)
 * @date 2020/8/25 20:27
 * description:
 **/
public class GreetServiceImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHi(SampleGrpc.SampleReq request, StreamObserver<SampleGrpc.SampleResp> responseObserver) {

        System.out.println(request.getContent());

        SampleGrpc.SampleResp resp = SampleGrpc.SampleResp.newBuilder().setResp("Hello " + request.getContent()).build();

        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
