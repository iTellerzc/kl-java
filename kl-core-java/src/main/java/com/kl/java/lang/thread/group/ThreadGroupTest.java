package com.kl.java.lang.thread.group;

import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 10:06
 * description:
 */
public class ThreadGroupTest {

    public static class T extends Thread{

        @Override
        public void run(){
            System.out.println("thread name:" + getName());
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

        System.out.println("活动线程数:" + tg.activeCount());
        System.out.println("活动线程组数:" + tg.activeGroupCount());
        System.out.println("线程组名称:" + tg.getName() + ", parent:" + tg.getParent().getName());
    }
}
