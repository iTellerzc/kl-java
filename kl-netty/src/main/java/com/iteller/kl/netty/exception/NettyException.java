package com.iteller.kl.netty.exception;

import com.iteller.kl.common.enums.KlExceptionEnums;
import com.iteller.kl.common.exception.KlException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 9:26
 * description:
 */
public class NettyException extends KlException {
    private static final long serialVersionUID = 359438219440211060L;

    public NettyException() {
    }

    public NettyException(KlExceptionEnums klExceptionEnums, Throwable cause) {
        super(klExceptionEnums, cause);
    }

    public NettyException(String message) {
        super(message);
    }

    public NettyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NettyException(Throwable cause) {
        super(cause);
    }
}
