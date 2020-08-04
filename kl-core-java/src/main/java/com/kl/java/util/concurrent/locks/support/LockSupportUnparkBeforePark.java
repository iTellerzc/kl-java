package com.kl.java.util.concurrent.locks.support;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 16:59
 * description:
 */
public class LockSupportUnparkBeforePark {

    public static class T extends Thread{

        @Override
        public void run(){
            try{
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + ", " + currentThread().getName() + " start");
            LockSupport.park();
            System.out.println(System.currentTimeMillis() + ", " + currentThread().getName() + "被唤醒");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("lockSupportThreadWithSeq");
        t.start();

        TimeUnit.SECONDS.sleep(1);

        LockSupport.unpark(t);
        System.out.println(System.currentTimeMillis() + ", LockSupport.unpark;执行完毕");
    }
}
