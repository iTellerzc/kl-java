package com.kl.java.ratelimit;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class SemaphoreLimit {

    static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args){

        for(int i=0; i<20; i++){
            new Thread(() -> {
                boolean flag = false;
                try {
                    flag = semaphore.tryAcquire(100, TimeUnit.MICROSECONDS);

                    if(flag){
                        System.out.println(Thread.currentThread() + "尝试下单中。。。");
                        TimeUnit.SECONDS.sleep(2);
                    }else {
                        System.out.println(Thread.currentThread() + "秒杀失败。。。");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if(flag){
                        semaphore.release();
                    }
                }
            }).start();
        }

    }
}
