package com.kl.rpc.simple.exception;

/**
 * @author iTeller_zc (000601)
 * @date 2020/8/8 9:33
 * description:基础rpc异常
 **/
public class RpcException extends Exception{
    private static final long serialVersionUID = -5950615690367991464L;

    public RpcException() {
    }

    public RpcException(String message) {
        super(message);
    }

    public RpcException(String message, Throwable cause) {
        super(message, cause);
    }
}
