package com.iteller.kl.common.enums;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 9:10
 * description:
 */
public enum  KlExceptionEnums {
    SYS_ERROR("kl.9999", "系统异常"),
    JSON_EXCEPTION("kl.0001", "json异常")
    ;

    private String errorCode;

    private String errorMsg;

    KlExceptionEnums(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
