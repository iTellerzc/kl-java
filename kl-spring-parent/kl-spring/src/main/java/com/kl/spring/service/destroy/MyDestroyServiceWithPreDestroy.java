package com.kl.spring.service.destroy;

import javax.annotation.PreDestroy;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 10:42
 * description:
 */
public class MyDestroyServiceWithPreDestroy {

    public MyDestroyServiceWithPreDestroy(){
        System.out.println("create " + getClass());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("pre destroy.");
    }
}
