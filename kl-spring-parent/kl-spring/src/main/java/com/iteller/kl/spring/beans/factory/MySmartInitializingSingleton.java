package com.iteller.kl.spring.beans.factory;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 9:55
 * description:
 */
@Component
public class MySmartInitializingSingleton implements SmartInitializingSingleton {

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("all beans initialized !");
    }
}
