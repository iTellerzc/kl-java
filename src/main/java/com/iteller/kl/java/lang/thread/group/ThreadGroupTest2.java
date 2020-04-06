package com.iteller.kl.java.lang.thread.group;

import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 10:06
 * description:
 */
public class ThreadGroupTest2 {

    public static class T extends Thread{

        @Override
        public void run(){
            System.out.println("thread name:" + currentThread().getName() + ",所属线程组:" + currentThread().getThreadGroup().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup tg = new ThreadGroup("tg");
        Thread t1 = new Thread(tg, new T(), "t1");
        Thread t2 = new Thread(tg, new T(), "t2");

        t1.start();
        t2.start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println("tg活动线程数:" + tg.activeCount());
        System.out.println("tg活动线程组数:" + tg.activeGroupCount());
        System.out.println("tg线程组名称:" + tg.getName() + ", parent:" + tg.getParent().getName());

        ThreadGroup tg2 = new ThreadGroup(tg, "tg2");
        Thread t3 = new Thread(tg2, new T(), "t3");
        Thread t4 = new Thread(tg2, new T(), "t4");
        t3.start();
        t4.start();

        System.out.println("-----------------");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("tg2活动线程数:" + tg2.activeCount());
        System.out.println("tg2活动线程组数:" + tg2.activeGroupCount());
        System.out.println("tg2线程组名称:" + tg2.getName() + ", parent:" + tg2.getParent().getName());

        System.out.println("-----------------");
        System.out.println("tg活动线程数:" + tg.activeCount());
        System.out.println("tg活动线程组数:" + tg.activeGroupCount());
        System.out.println("tg线程组名称:" + tg.getName() + ", parent:" + tg.getParent().getName());

        System.out.println("------------------");
        tg.list();

    }
}
