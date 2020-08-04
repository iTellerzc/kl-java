package com.kl.spring.mvc.consts;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/16 11:39
 * description:
 */
public enum  ErrorEnums {
    TEST_ERROR(concat("000"), "test error!"),
    BAD_REQUEST(concat("001"), "bad request!"),
    METHOD_NOT_SUPPORT(concat("002"), "method not support!"),
    TYPE_NOT_SUPPORT(concat("004"), "media type not support!"),
    ILLEGAL_PARAMS(concat("005"), "illegal params!"),
    SYS_ERROR(concat("999"), "sys error!")
    ;

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private ErrorEnums(){

    }

    private ErrorEnums(String errorCode, String errorMsg){
        this.code = errorCode;
        this.msg = errorMsg;
    }

    static String concat(String errorCode){
        return ModuleConsts.MODULE_PEFFIX + errorCode;
    }

}
