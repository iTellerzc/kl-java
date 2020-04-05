package com.iteller.kl.java.lang.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/5
 * description:
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){

            @Override
            public void run(){
                while(true){
                    if(isInterrupted()){
                        System.out.println("exit cause interrupted.");
                        break;
                    }
                }
            }
        };

        t1.setName("t1");
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        TimeUnit.SECONDS.sleep(2);
        System.out.println(t1.getState());
        t1.interrupt();
        System.out.println(t1.getState());
    }
}
