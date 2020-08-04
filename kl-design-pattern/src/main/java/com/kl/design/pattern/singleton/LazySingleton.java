package com.kl.design.pattern.singleton;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/21 15:02
 * description:
 */
public class LazySingleton {

    private LazySingleton(){

    }

    private static LazySingleton instance;

    public static synchronized LazySingleton getInstance(){
        if (null == instance){
            instance = new LazySingleton();
        }
        return instance;
    }
}
