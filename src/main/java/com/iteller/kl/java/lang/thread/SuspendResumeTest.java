package com.iteller.kl.java.lang.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/5
 * description:不会释放锁资源，线程挂起
 */
public class SuspendResumeTest {

    static Object monitorObj = new Object();

    public static class T1 extends Thread{

        public T1(String name){
            super(name);
        }

        @Override
        public void run(){
            synchronized (monitorObj){
                System.out.println("in " + getName());
                //System.out.println("equals:" + this.getName().equals(Thread.currentThread().getName()));
                try {
                    TimeUnit.SECONDS.sleep(2);
                    Thread.currentThread().suspend();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    interrupt();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1("t1");
        T1 t2 = new T1("t2");
        t1.start();
        TimeUnit.SECONDS.sleep(1);

        t2.start();

        t1.resume();
        System.out.println("t1 resume.");
        t2.resume();
        System.out.println("t2 resume.");

        t1.join(1000);//等待线程结束
        System.out.println("t1 end.");
        t2.join();
        System.out.println("t2 end.");


    }
}
