package com.kl.spring.aop.sample.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/13 17:19
 * description:
 */
@Aspect
public class AuditableAspect {

    @Before("CombinePointcutAspect.anyPublicOperation() " +
            "&& @annotation(auditable)")
    public void audit(Auditable auditable){
        auditable.value();
    }

    @Before(value = "CombinePointcutAspect.anyPublicOperation() " +
            "&& target(bean) " +
            "&& @annotation(auditable)"/*, argNames = "bean,auditable"*/)
    public void auditWithArgNames(JoinPoint jb, Object bean, Auditable auditable){
        auditable.value();
    }
}
