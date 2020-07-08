package com.iteller.kl.netty.builder;

import com.iteller.kl.netty.dto.base.NettyBaseHeader;
import com.iteller.kl.netty.dto.base.NettyReq;
import com.iteller.kl.netty.dto.base.NettyResp;
import com.iteller.kl.netty.exception.NettyException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 9:35
 * description:
 */
public class TransportBuilder {

    public static NettyReq buildReq(NettyBaseHeader nettyBaseHeader, Object obj){
        NettyReq nettyReq = new NettyReq(nettyBaseHeader, obj);
        nettyReq.setReqTime(System.currentTimeMillis());
        return nettyReq;
    }

    public static NettyResp buildRespWithError(NettyBaseHeader nettyBaseHeader, Object obj, NettyException nettyException){
        NettyResp nettyResp = new NettyResp(nettyBaseHeader, obj);
        if(nettyException != null){
            nettyResp.setNettyException(nettyException);
        }
        nettyResp.setRespTime(System.currentTimeMillis());
        return nettyResp;
    }

    public static NettyResp buildResp(NettyBaseHeader nettyBaseHeader, Object obj){
        NettyResp nettyResp = new NettyResp(nettyBaseHeader, obj);
        nettyResp.setRespTime(System.currentTimeMillis());
        return nettyResp;
    }
}
