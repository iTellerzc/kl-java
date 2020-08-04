package com.kl.java.util.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 10:15
 * description:
 *
 * 创建CountDownLatch对象
 * 调用其实例方法 await()，让当前线程等待
 * 调用 countDown()方法，让计数器减1
 * 当计数器变为0的时候， await()方法会返回
 */
public class CountDownLatchTest {

    public static class T extends Thread{

        int sleepSeconds;
        CountDownLatch countDownLatch;

        public T(String name, int sleepSeconds, CountDownLatch countDownLatch){
            super(name);
            this.sleepSeconds = sleepSeconds;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run(){
            Thread currentThread = currentThread();
            long startTime = System.currentTimeMillis();
            System.out.println(startTime+", " + currentThread.getName() + "开始处理");
            try{
                TimeUnit.SECONDS.sleep(sleepSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime+", " + currentThread.getName() + "处理结束,耗时:" + (endTime - startTime) + " ms");

        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 线程start");
        CountDownLatch countDownLatch = new CountDownLatch(2);

        long startTime = System.currentTimeMillis();
        T t1 = new T("t1", 2, countDownLatch);
        t1.start();

        T t2 = new T("t2", 5, countDownLatch);
        t2.start();

        countDownLatch.await();
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 线程end");
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时:" + (endTime-startTime) + " ms");

    }
}
