package com.kl.spring.aop.sample;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/13 16:41
 * description:
 */
@Aspect
public class AfterAdvice {

    @After("SystemArchitecture.dataAccessOperation()")
    public void doReleaseLock(){

    }
}
