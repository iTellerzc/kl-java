package com.kl.rpc.self.dto.base;

import com.kl.rpc.self.exception.TransportException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:21
 * description:请求
 */
public class RespTransport extends BaseTransport {
    private static final long serialVersionUID = 2709761496458960404L;

    /**
     * 响应体
     */
    private Object resp;

    private TransportException transportException;

    public RespTransport(){

    }

    public TransportException getTransportException() {
        return transportException;
    }

    public void setTransportException(TransportException transportException) {
        this.transportException = transportException;
    }

    public Object getResp() {
        return resp;
    }

    public void setResp(Object resp) {
        this.resp = resp;
    }
}
