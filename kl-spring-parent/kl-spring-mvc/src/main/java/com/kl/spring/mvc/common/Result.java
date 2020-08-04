package com.kl.spring.mvc.common;

import java.io.Serializable;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/16 10:02
 * description:
 */
public class Result<T> implements Serializable{

    private boolean success;

    private T data;

    private ErrorCtx errorCtx;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorCtx getErrorCtx() {
        return errorCtx;
    }

    public void setErrorCtx(ErrorCtx errorCtx) {
        this.errorCtx = errorCtx;
    }
}
