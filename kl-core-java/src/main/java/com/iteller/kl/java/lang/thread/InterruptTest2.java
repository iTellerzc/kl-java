package com.iteller.kl.java.lang.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/5
 * description:
 */
public class InterruptTest2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){

            @Override
            public void run(){
                while(true){
                    try{
                        TimeUnit.SECONDS.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        //线程中断标识 sleep因为中断而抛出异常后，中断标志会被清除true-false,需要再次设置为true
                        interrupt();
                    }
                    if(this.isInterrupted()){
                        System.out.println("exit cause interrupt flag.");
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
