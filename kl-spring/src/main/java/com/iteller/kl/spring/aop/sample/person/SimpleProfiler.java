package com.iteller.kl.spring.aop.sample.person;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/14 9:54
 * description:
 */
public class SimpleProfiler {

    public Object profile(ProceedingJoinPoint pjp, String name, int age) throws Throwable {
        StopWatch stopWatch = new StopWatch("profile for '" + name + "' and '" + age + ",");

        try{
            stopWatch.start(pjp.toShortString());
            return pjp.proceed();
        }finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }

    }
}
