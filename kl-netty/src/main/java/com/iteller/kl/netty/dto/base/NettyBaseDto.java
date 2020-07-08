package com.iteller.kl.netty.dto.base;

import java.io.Serializable;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:22
 * description:
 */
public class NettyBaseDto implements Serializable{

    private static final long serialVersionUID = 6373740936269254302L;

    /**
     * 请求头
     */
    private NettyBaseHeader nettyBaseHeader;

    /**
     * 请求时间
     */
    private Long reqTime;

    /**
     * 响应时间
     */
    private Long respTime;

    public NettyBaseHeader getNettyBaseHeader() {
        return nettyBaseHeader;
    }

    public void setNettyBaseHeader(NettyBaseHeader nettyBaseHeader) {
        this.nettyBaseHeader = nettyBaseHeader;
    }

    public Long getReqTime() {
        return reqTime;
    }

    public void setReqTime(Long reqTime) {
        this.reqTime = reqTime;
    }

    public Long getRespTime() {
        return respTime;
    }

    public void setRespTime(Long respTime) {
        this.respTime = respTime;
    }
}
