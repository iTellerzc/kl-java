package com.iteller.kl.java.lang.thread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 10:39
 * description:
 */
public class DaemonThreadExtendTest {

    public static class DaemonThread extends Thread{

        public DaemonThread(String name){
            super(name);
        }

        @Override
        public void run(){
            System.out.println("thread name:" + getName() + "," + isDaemon());
            while(true);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+".daemon:" + Thread.currentThread().isDaemon());

        DaemonThread dt = new DaemonThread("dt");
        dt.start();

        Thread t2 = new Thread(){

            @Override
            public void run(){
                System.out.println(getName() +".daemon:" + isDaemon());
                DaemonThread t3 = new DaemonThread("dt3");
                t3.start();
            }
        };
        t2.setName("t2");
        t2.setDaemon(true);
        t2.start();

        TimeUnit.SECONDS.sleep(5);
    }
}
