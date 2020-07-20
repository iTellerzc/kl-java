package com.iteller.kl.rpc.self.exception;

import com.iteller.kl.common.enums.KlExceptionEnums;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:20
 * description:
 */
public class TransportBizException extends TransportException {
    private static final long serialVersionUID = 6645706036317318490L;

    public TransportBizException() {
    }

    public TransportBizException(KlExceptionEnums klExceptionEnums, Throwable cause) {
        super(klExceptionEnums, cause);
    }

    public TransportBizException(String message) {
        super(message);
    }

    public TransportBizException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransportBizException(Throwable cause) {
        super(cause);
    }
}
