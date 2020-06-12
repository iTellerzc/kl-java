package com.iteller.kl.spring.aop.sample.ltw.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/14 16:59
 * description:
 */
@Aspect
public class ProfilingAspect {

    @Around("methodsToBeProfiled()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch sw = new StopWatch(getClass().getSimpleName());
        try{
            sw.start(pjp.getSignature().getName());
            return pjp.proceed();
        }finally {
            sw.stop();
            System.out.println(sw.prettyPrint());
        }

    }

    @Pointcut("execution(public * com.iteller.kl.spring.aop.sample.ltw.service..*.*(..))")
    public void methodsToBeProfiled(){

    }
}
