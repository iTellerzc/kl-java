package com.kl.java.util.random;

import java.util.Random;

/**
 * author:18060903(iTeller_zc)
 * date:2019/12/5 10:52
 * description:
 */
public class MyRandom {

    public static void main(String[] args){
        Random random = new Random();
        for(int i = 0; i< 10; i++){
            System.out.println(random.nextInt(10));
        }
    }
}
