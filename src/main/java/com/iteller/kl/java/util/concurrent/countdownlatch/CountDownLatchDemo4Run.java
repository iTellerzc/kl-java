package com.iteller.kl.java.util.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 10:31
 * description:
 */
public class CountDownLatchDemo4Run {

    public static class T extends Thread{

        int runCostSeconds;

        CountDownLatch commander;

        CountDownLatch countDownLatch;

        public T(String name, int runCostSeconds, CountDownLatch commander, CountDownLatch countDownLatch){
            super(name);
            this.runCostSeconds = runCostSeconds;
            this.commander = commander;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run(){
            //等待指令
            try {
                commander.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Thread currentThread = currentThread();
            long startTime = System.currentTimeMillis();
            System.out.println(startTime + ", " + currentThread.getName() + "开始跑");
            try {
                TimeUnit.SECONDS.sleep(runCostSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
            long endTime = System.currentTimeMillis();
            System.out.println(startTime + ", " + currentThread.getName() + "跑步结束,耗时:" + (endTime-startTime) + " ms");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis() + ", " + Thread.currentThread().getName() + " 线程start");
        CountDownLatch commander = new CountDownLatch(1);
        CountDownLatch runner = new CountDownLatch(3);

        long startTime = System.currentTimeMillis();
        T t1 = new T("tracy", 3, commander, runner);
        T t2 = new T("iteller", 5, commander, runner);
        T t3 = new T("jack", 2, commander, runner);
        t1.start();
        t2.start();
        t3.start();

        TimeUnit.SECONDS.sleep(3);
        //跑步指令下发
        commander.countDown();

        runner.await();
        long endTime = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() + ", " + Thread.currentThread().getName() + " 线程end, 耗时:" + (endTime-startTime) + " ms");

    }
}
