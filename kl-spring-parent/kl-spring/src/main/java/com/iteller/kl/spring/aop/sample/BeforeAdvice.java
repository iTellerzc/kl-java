package com.iteller.kl.spring.aop.sample;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/13 16:27
 * description:
 */
@Aspect
public class BeforeAdvice {

    @Before("com.iteller.kl.spring.aop.pointcut.share.SystemArchitecture.dataAccessOperation()")
    public void dataAccessCheck(){
        //your check logic
    }

    @Before("* com.iteller.kl.spring.aop.pointcut.share.dao.*.*(..)")
    public void dataAccessCheckWithPlace(){

    }

    /**
     * xml config
     */
    public void monitor(Object service){

    }
}
