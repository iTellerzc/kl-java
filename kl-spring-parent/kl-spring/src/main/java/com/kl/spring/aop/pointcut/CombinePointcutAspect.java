package com.kl.spring.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/13 15:04
 * description:
 */
@Aspect
public class CombinePointcutAspect {

    @Pointcut("execution((public * *(..)))")
    public void anyPublicOperation(){

    }

    @Pointcut("within(com.iteller.kl.spring.aop.sample..*)")
    public void inTrading(){

    }

    @Pointcut("anyPublicOperation() && inTrading()")
    public void tradingOperation(){

    }
}
