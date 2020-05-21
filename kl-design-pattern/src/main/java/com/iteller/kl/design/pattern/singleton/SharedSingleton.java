package com.iteller.kl.design.pattern.singleton;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/21 15:04
 * description:
 */
public class SharedSingleton {

    private static volatile SharedSingleton instance;

    private SharedSingleton(){

    }

    public static SharedSingleton getInstance(){
        if(null == instance){
            synchronized (SharedSingleton.class){
                if(null == instance){
                    instance = new SharedSingleton();
                }
            }
        }
        return instance;
    }
}
