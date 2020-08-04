package com.kl.spring.mvc.common;

import java.io.Serializable;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/16 10:03
 * description:
 */
public class ErrorCtx implements Serializable{

    private String code;

    private String msg;

    public ErrorCtx(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
