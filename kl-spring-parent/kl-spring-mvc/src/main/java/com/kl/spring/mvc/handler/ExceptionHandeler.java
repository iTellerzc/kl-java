package com.kl.spring.mvc.handler;

import com.kl.spring.mvc.common.Result;
import com.kl.spring.mvc.consts.ErrorEnums;
import com.kl.spring.mvc.exception.MvcBizException;
import com.kl.spring.mvc.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/16 9:59
 * description:
 */
@ControllerAdvice(basePackages = {"com.iteller.kl.spring.mvc.ctr"})
public class ExceptionHandeler{

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandeler.class);

    /**
     * mapping match exception
     * @param e
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result handleInvokeException(Exception e){
        LOGGER.warn("handle biz meet error!", e);
        if (e instanceof HttpMessageNotReadableException){
            return ResultUtil.buildError(ErrorEnums.BAD_REQUEST);
        }else if(e instanceof HttpMediaTypeNotSupportedException){
            return ResultUtil.buildError(ErrorEnums.TYPE_NOT_SUPPORT);
        }else if(e instanceof HttpRequestMethodNotSupportedException){
            return ResultUtil.buildError(ErrorEnums.METHOD_NOT_SUPPORT);
        }else if(e instanceof IllegalArgumentException){
            return ResultUtil.buildError(ErrorEnums.ILLEGAL_PARAMS);
        }else if(e instanceof MethodArgumentTypeMismatchException){
            return ResultUtil.buildError(ErrorEnums.TYPE_NOT_SUPPORT);
        }else if(e instanceof MvcBizException){
            MvcBizException mvcBizException = (MvcBizException) e;
            return ResultUtil.buildError(mvcBizException.getErrorEnums());
        }else {
            return ResultUtil.buildError(ErrorEnums.SYS_ERROR);
        }
    }
}
