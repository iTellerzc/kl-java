package com.iteller.kl.java.util.concurrent.demo.count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class AtomicLongCount {

    static AtomicLong count = new AtomicLong(0);

    public static void add(){
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<10; i++){
            count.set(0);
            m1();
        }
    }

    public static void m1() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int threadNum = 50;

        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i=0; i<threadNum; i++){
            new Thread(() -> {
                try{
                    for (int j=0; j<1000000; j++){
                        add();
                    }
                }finally {
                    countDownLatch.countDown();
                }

            }).start();
        }

        countDownLatch.await();

        long endTime = System.currentTimeMillis();

        System.out.println(String.format("spend %s ms, count:%s", (endTime-startTime), count));
    }
}
