package com.iteller.kl.java.util.concurrent.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/8 20:08
 * description:
 */
public class MyAtomicIntegerCount {

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间:" + startTime);
        int threadSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for(int i=0; i<threadSize; i++){
            Thread thread = new Thread(() -> {
                try {
                    for(int j=0; j<10; j++){
                        request();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }

        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:" + (endTime - startTime) + " ms, count:" + count.get());
    }

    private static void request() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(2);
        count.getAndIncrement();
    }

}
