package com.kl.rpc.simple.exception;

/**
 * @author iTeller_zc (000601)
 * @date 2020/8/8 9:58
 * description:
 **/
public class LifyCycleException extends RuntimeException {
    private static final long serialVersionUID = 2793890166414652003L;

    public LifyCycleException() {
    }

    public LifyCycleException(String message) {
        super(message);
    }

    public LifyCycleException(String message, Throwable cause) {
        super(message, cause);
    }
}
