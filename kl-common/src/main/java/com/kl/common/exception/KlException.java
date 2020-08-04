package com.kl.common.exception;

import com.kl.common.enums.KlExceptionEnums;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 9:00
 * description:
 */
public class KlException extends RuntimeException {
    private static final long serialVersionUID = 7079018951065024106L;

    private KlExceptionEnums klExceptionEnums;

    public KlExceptionEnums getKlExceptionEnums() {
        return klExceptionEnums;
    }

    public void setKlExceptionEnums(KlExceptionEnums klExceptionEnums) {
        this.klExceptionEnums = klExceptionEnums;
    }

    public KlException() {
    }

    public  KlException(KlExceptionEnums klExceptionEnums, Throwable cause){
        super("errCode:" + klExceptionEnums.getErrorCode() + ", errMsg:" + klExceptionEnums.getErrorMsg(), cause);
        this.klExceptionEnums = klExceptionEnums;
    }

    public KlException(String message) {
        super(message);
    }

    public KlException(String message, Throwable cause) {
        super(message, cause);
    }

    public KlException(Throwable cause) {
        super(cause);
    }
}
