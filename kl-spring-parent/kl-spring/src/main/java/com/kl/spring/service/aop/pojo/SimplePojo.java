package com.kl.spring.service.aop.pojo;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/14 10:44
 * description:
 */
public class SimplePojo implements Pojo {
    @Override
    public void foo() {
        this.bar();
    }

    @Override
    public void bar() {
        System.out.println("do bar");
    }
}
