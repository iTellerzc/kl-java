package com.kl.java.util.concurrent.locks.support;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 16:59
 * description:
 */
public class LockSupportWithNanos {

    public static class T extends Thread{

        @Override
        public void run(){
            System.out.println(System.currentTimeMillis() + ", " + currentThread().getName() + " start");
            System.out.println(currentThread().getName() + ",park()之前中断标志:" + isInterrupted());
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));
            System.out.println(currentThread().getName() + ",park()之后中断标志:" + isInterrupted());
            System.out.println(System.currentTimeMillis() + ", " + currentThread().getName() + "被唤醒");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("lockSupportWithInterruptThread");
        t.start();
        //t.join();
        TimeUnit.SECONDS.sleep(3);

        t.interrupt();
    }
}
