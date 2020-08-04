package com.kl.spring.aop.pointcut.share;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/13 15:11
 * description:
 */
@Aspect
public class SystemArchitecture {

    @Pointcut("within(com.iteller.kl.spring.aop.pointcut.share.web..*)")
    public void inWebLayer(){

    }

    @Pointcut("within(com.iteller.kl.spring.aop.pointcut.share.service..*)")
    public void inServiceLayer(){

    }

    @Pointcut("within(com.iteller.kl.spring.aop.pointcut.share.dao..*)")
    public void inDaoLayer(){

    }

    @Pointcut("execution(* com.iteller.kl.spring.service.*.*(..))")
    public void businessService(){

    }

    @Pointcut("execution(* com.iteller.kl.spring.aop.pointcut.share.dao.*.*(..))")
    public void dataAccessOperation(){

    }
}
