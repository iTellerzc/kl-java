package com.kl.java.lang.thread.group;

import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 10:23
 * description:
 */
public class ThreadGroupInterruptTest {

    public static class T extends Thread{

        @Override
        public void run(){
            Thread thread = currentThread();
            System.out.println("thread group name:" + thread.getThreadGroup().getName() +", current thread name:" + thread.getName());
            while (!thread.isInterrupted()){
                ;
            }
            System.out.println("线程：" + thread.getName() + "中断停止！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup tg1 = new ThreadGroup("tg1");

        Thread  t1 = new Thread(tg1, new T(), "t1");
        Thread t2 = new Thread(tg1, new T(), "t2");

        t1.start();
        t2.start();

        ThreadGroup tg2 = new ThreadGroup(tg1, "tg2");
        Thread t3 = new Thread(tg2, new T(), "t3");
        Thread t4 = new Thread(tg2, new T(), "t4");

        t3.start();
        t4.start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println("--tg1 info--");
        tg1.list();

        System.out.println("--------------");
        System.out.println("中断tg1线程组:");
        tg1.interrupt();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("after interrupt, tg1 info:");
        tg1.list();
    }
}
