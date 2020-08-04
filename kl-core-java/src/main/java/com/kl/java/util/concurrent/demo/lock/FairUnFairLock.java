package com.kl.java.util.concurrent.demo.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class FairUnFairLock {

    public static final Logger LOGGER = LoggerFactory.getLogger(FairUnFairLock.class);

    public static void main(String[] args) throws InterruptedException {
        lock(false);

        TimeUnit.SECONDS.sleep(4);
        System.out.println("--------");

        lock(true);
    }

    private static void lock(boolean b) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock(b);
        Thread t1 = new Thread(() -> {

            reentrantLock.lock();
            try {
                LOGGER.info("start");
                TimeUnit.SECONDS.sleep(3);
                new Thread(() -> {
                    m1(reentrantLock, "son");
                }).start();
                LOGGER.info("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        });

        t1.setName("t1");
        t1.start();

        System.out.println("current thread name:" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(1);

        m1(reentrantLock, "father");
    }

    private static void m1(ReentrantLock reentrantLock, String prefix) {
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(() -> {
                reentrantLock.lock();
                try{
                    LOGGER.info("获取到锁！");
                }finally {
                    reentrantLock.unlock();
                }
            });
            thread.setName(prefix + i);
            thread.start();

        }
    }
}
