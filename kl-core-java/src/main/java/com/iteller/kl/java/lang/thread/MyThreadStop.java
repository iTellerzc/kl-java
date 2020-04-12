package com.iteller.kl.java.lang.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/5
 * description:
 */
public class MyThreadStop {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){

            @Override
            public void run(){
                boolean flag = true;
                while(flag){
                    System.out.println(getState() == State.RUNNABLE ? "running" : "not running");
                }

            }
        };

        t1.start();

        TimeUnit.SECONDS.sleep(1);

        t1.stop();

        System.out.println(t1.getState());

        TimeUnit.SECONDS.sleep(1);
        System.out.println(t1.getState());


    }
}
