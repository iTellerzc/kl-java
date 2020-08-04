package com.kl.spring.aop.sample;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/13 16:42
 * description:
 */
@Aspect
public class AroundAdvice {

    @Around("SystemArchitecture.businessService()")
    public Object doBasicProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retVal = proceedingJoinPoint.proceed();
        return retVal;

    }
}
