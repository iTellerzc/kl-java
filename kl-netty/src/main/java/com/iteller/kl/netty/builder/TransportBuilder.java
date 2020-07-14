package com.iteller.kl.netty.builder;

import com.iteller.kl.netty.dto.base.TransportHeader;
import com.iteller.kl.netty.dto.base.ReqTransport;
import com.iteller.kl.netty.dto.base.RespTransport;
import com.iteller.kl.netty.exception.NettyException;

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

    public static RespTransport buildRespWithError(TransportHeader transportHeader, Object obj, NettyException nettyException){
        RespTransport nettyResp = new RespTransport();
        if(nettyException != null){
            nettyResp.setNettyException(nettyException);
        }
        return nettyResp;
    }

    public static RespTransport buildResp(TransportHeader transportHeader, Object obj){
        RespTransport nettyResp = new RespTransport();
        return nettyResp;
    }
}
