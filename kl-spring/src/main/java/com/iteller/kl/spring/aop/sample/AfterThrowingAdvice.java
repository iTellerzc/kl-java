package com.iteller.kl.spring.aop.sample;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/13 16:37
 * description:
 */
@Aspect
public class AfterThrowingAdvice {

    @AfterThrowing("com.iteller.kl.spring.aop.pointcut.share.SystemArchitecture.dataAccessOperation()")
    public void doRecoveryAction(){

    }

    @AfterThrowing(
            pointcut = "com.iteller.kl.spring.aop.pointcut.share.SystemArchitecture.dataAccessOperation()",
            throwing = "ex"
    )
    public void doRecoveryAction(DataAccessException ex){

    }

}
