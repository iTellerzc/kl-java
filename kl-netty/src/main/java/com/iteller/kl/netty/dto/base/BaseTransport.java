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
     * @see  NettyBaseHeader
     */
    private byte[] headers;

    private byte[] clazz;

    private byte[] body;

    public byte[] getHeaders() {
        return headers;
    }

    public void setHeaders(byte[] headers) {
        this.headers = headers;
    }

    public byte[] getClazz() {
        return clazz;
    }

    public void setClazz(byte[] clazz) {
        this.clazz = clazz;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
