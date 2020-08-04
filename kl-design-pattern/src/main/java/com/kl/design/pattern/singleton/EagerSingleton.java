package com.kl.design.pattern.singleton;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/21 15:01
 * description:
 */
public class EagerSingleton {

    private EagerSingleton(){

    }

    private static EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance(){
        return instance;
    }
}
