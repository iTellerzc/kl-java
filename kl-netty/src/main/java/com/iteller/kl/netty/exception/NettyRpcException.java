package com.iteller.kl.netty.exception;

import com.iteller.kl.common.enums.KlExceptionEnums;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:20
 * description:
 */
public class NettyRpcException extends NettyException {
    private static final long serialVersionUID = 7512054791059084280L;

    public NettyRpcException() {
    }

    public NettyRpcException(KlExceptionEnums klExceptionEnums, Throwable cause) {
        super(klExceptionEnums, cause);
    }

    public NettyRpcException(String message) {
        super(message);
    }

    public NettyRpcException(String message, Throwable cause) {
        super(message, cause);
    }

    public NettyRpcException(Throwable cause) {
        super(cause);
    }
}
