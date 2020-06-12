package com.iteller.kl.spring.aop.sample;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/13 16:30
 * description:
 */
@Aspect
public class AfterReturnAdvice {

    @AfterReturning("com.iteller.kl.spring.aop.pointcut.share.SystemArchitecture.dataAccessOperation()")
    public void dataAccessCheck(){

    }

    @AfterReturning(
            pointcut = "com.iteller.kl.spring.aop.pointcut.share.SystemArchitecture.dataAccessOperation()",
            returning = "retVal"
    )
    public void dataAccessCheckWithObj(Object retVal){

    }
}
