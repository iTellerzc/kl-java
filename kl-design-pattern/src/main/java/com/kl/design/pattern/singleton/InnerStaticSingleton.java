package com.kl.design.pattern.singleton;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/21 15:06
 * description:
 */
public class InnerStaticSingleton {

    private InnerStaticSingleton(){

    }

    private static class InnerSingleton{
        private static InnerStaticSingleton instance = new InnerStaticSingleton();
    }

    public static InnerStaticSingleton getInstance(){
        return InnerSingleton.instance;
    }

}
