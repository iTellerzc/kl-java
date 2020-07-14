package com.iteller.kl.netty.dto.base;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:21
 * description:响应
 */
public class NettyReq extends NettyBaseDto{

    private static final long serialVersionUID = -7651142304529345908L;

    /**
     * 请求体
     */
    private Object req;

    public Object getReq() {
        return req;
    }

    public void setReq(Object req) {
        this.req = req;
    }

    public NettyReq(){
    }

    public NettyReq(NettyBaseHeader nettyBaseHeader, Object obj){
        super.setNettyBaseHeader(nettyBaseHeader);
        super.setReqTime(System.currentTimeMillis());
        this.req = obj;
    }
}
