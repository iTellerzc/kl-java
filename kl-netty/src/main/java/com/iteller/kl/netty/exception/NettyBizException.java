package com.iteller.kl.netty.exception;

import com.iteller.kl.common.enums.KlExceptionEnums;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:20
 * description:
 */
public class NettyBizException extends NettyException{
    private static final long serialVersionUID = 6645706036317318490L;

    public NettyBizException() {
    }

    public NettyBizException(KlExceptionEnums klExceptionEnums, Throwable cause) {
        super(klExceptionEnums, cause);
    }

    public NettyBizException(String message) {
        super(message);
    }

    public NettyBizException(String message, Throwable cause) {
        super(message, cause);
    }

    public NettyBizException(Throwable cause) {
        super(cause);
    }
}
