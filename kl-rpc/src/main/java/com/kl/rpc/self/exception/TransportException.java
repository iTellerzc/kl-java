package com.kl.rpc.self.exception;

import com.kl.common.enums.KlExceptionEnums;
import com.kl.common.exception.KlException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 9:26
 * description:
 */
public class TransportException extends KlException {
    private static final long serialVersionUID = 359438219440211060L;

    public TransportException() {
    }

    public TransportException(KlExceptionEnums klExceptionEnums, Throwable cause) {
        super(klExceptionEnums, cause);
    }

    public TransportException(String message) {
        super(message);
    }

    public TransportException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransportException(Throwable cause) {
        super(cause);
    }
}
