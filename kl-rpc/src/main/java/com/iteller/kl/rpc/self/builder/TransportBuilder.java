package com.iteller.kl.rpc.self.builder;

import com.iteller.kl.rpc.self.dto.base.TransportHeader;
import com.iteller.kl.rpc.self.dto.base.ReqTransport;
import com.iteller.kl.rpc.self.dto.base.RespTransport;
import com.iteller.kl.rpc.self.exception.TransportException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 9:35
 * description:
 */
public class TransportBuilder {

    public static ReqTransport buildReq(TransportHeader transportHeader, Object obj){
        ReqTransport nettyReq = new ReqTransport();
        return nettyReq;
    }

    public static RespTransport buildRespWithError(TransportHeader transportHeader, Object obj, TransportException transportException){
        RespTransport nettyResp = new RespTransport();
        if(transportException != null){
            nettyResp.setTransportException(transportException);
        }
        return nettyResp;
    }

    public static RespTransport buildResp(TransportHeader transportHeader, Object obj){
        RespTransport nettyResp = new RespTransport();
        return nettyResp;
    }
}
