package com.iteller.kl.spring.service.aop.pojo;

import org.springframework.aop.framework.AopContext;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/14 10:44
 * description:
 */
public class SimplePojoWithAop implements Pojo {
    @Override
    public void foo() {
        ((Pojo)AopContext.currentProxy()).bar();
    }

    @Override
    public void bar() {
        System.out.println("aop proxy do bar");
    }
}
