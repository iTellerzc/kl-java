package com.kl.spring.mvc.util;

import com.kl.spring.mvc.common.ErrorCtx;
import com.kl.spring.mvc.common.Result;
import com.kl.spring.mvc.consts.ErrorEnums;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/16 11:08
 * description:
 */
public class ResultUtil {

    public static Result buildError(String code, String msg){
        Result result = new Result();
        result.setSuccess(false);
        ErrorCtx errorCtx = new ErrorCtx(code, msg);
        result.setErrorCtx(errorCtx);
        return result;
    }

    public static Result buildError(ErrorEnums errorEnums){
        Result result = new Result();
        result.setSuccess(false);
        ErrorCtx errorCtx = new ErrorCtx(errorEnums.getCode(), errorEnums.getMsg());
        result.setErrorCtx(errorCtx);
        return result;
    }

    public static <T> Result<T> buildSuccess(T data){
        Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static Result buildSuccessNoData(){
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }
}
