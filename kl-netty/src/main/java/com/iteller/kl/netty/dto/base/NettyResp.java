package com.iteller.kl.netty.dto.base;

import com.iteller.kl.netty.exception.NettyException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:21
 * description:请求
 */
public class NettyResp extends NettyBaseDto{
    private static final long serialVersionUID = 2709761496458960404L;

    /**
     * 响应体
     */
    private Object resp;

    private NettyException nettyException;

    public NettyResp(){

    }

    public NettyResp(NettyBaseHeader nettyBaseHeader, Object obj){
        super.setNettyBaseHeader(nettyBaseHeader);
        super.setRespTime(System.currentTimeMillis());
        this.resp = obj;
    }

    public NettyException getNettyException() {
        return nettyException;
    }

    public void setNettyException(NettyException nettyException) {
        this.nettyException = nettyException;
    }

    public Object getResp() {
        return resp;
    }

    public void setResp(Object resp) {
        this.resp = resp;
    }
}
