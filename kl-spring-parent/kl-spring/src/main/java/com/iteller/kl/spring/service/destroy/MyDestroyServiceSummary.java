package com.iteller.kl.spring.service.destroy;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 10:42
 * description:
 */
public class MyDestroyServiceSummary implements DisposableBean {

    public MyDestroyServiceSummary(){
        System.out.println("create " + getClass());
    }

    @PreDestroy
    public void preDestroy1(){
        System.out.println("pre destroy 1");
    }

    @PreDestroy
    public void preDestroy2(){
        System.out.println("pre destroy 2");
    }

    public void selfDestroy(){
        System.out.println("self destroy.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("disposable bean destroy.");
    }
}
