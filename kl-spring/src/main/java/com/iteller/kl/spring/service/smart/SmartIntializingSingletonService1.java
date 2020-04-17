package com.iteller.kl.spring.service.smart;

import org.springframework.stereotype.Component;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 9:53
 * description:
 */
@Component
public class SmartIntializingSingletonService1 {

    public SmartIntializingSingletonService1(){
        System.out.println("create " + getClass());
    }
}
