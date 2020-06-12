package com.iteller.kl.spring.beans.factory;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 9:28
 * description:
 */
public class MyInitClass implements InitializingBean {

    public void init(){
        System.out.println("invoke init!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("invoke  afterPropertiesSet!");
    }
}
