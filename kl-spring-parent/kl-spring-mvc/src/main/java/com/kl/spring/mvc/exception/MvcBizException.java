package com.kl.spring.mvc.exception;

import com.kl.spring.mvc.consts.ErrorEnums;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/16 11:24
 * description:
 */
public class MvcBizException extends RuntimeException {

    private ErrorEnums errorEnums;

    public ErrorEnums getErrorEnums() {
        return errorEnums;
    }

    public MvcBizException(){
        super();
    }

    public MvcBizException(String message, ErrorEnums errorEnums) {
        super(message);
        this.errorEnums = errorEnums;
    }

    public MvcBizException(String message, Throwable cause, ErrorEnums errorEnums) {
        super(message, cause);
        this.errorEnums = errorEnums;
    }

    public MvcBizException(Throwable cause, ErrorEnums errorEnums) {
        super(cause);
        this.errorEnums = errorEnums;
    }
}
