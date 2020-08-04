package com.kl.rpc.self.exception;

import com.kl.common.enums.KlExceptionEnums;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:20
 * description:
 */
public class TransportRpcException extends TransportException {
    private static final long serialVersionUID = 7512054791059084280L;

    public TransportRpcException() {
    }

    public TransportRpcException(KlExceptionEnums klExceptionEnums, Throwable cause) {
        super(klExceptionEnums, cause);
    }

    public TransportRpcException(String message) {
        super(message);
    }

    public TransportRpcException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransportRpcException(Throwable cause) {
        super(cause);
    }
}
