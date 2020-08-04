package com.kl.spring.service.smart;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 9:53
 * description:
 */
@Component
@Lazy
public class SmartIntializingSingletonService2 {

    public SmartIntializingSingletonService2(){
        System.out.println("create " + getClass());
    }
}
