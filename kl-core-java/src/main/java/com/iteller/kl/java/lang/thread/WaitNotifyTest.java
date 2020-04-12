package com.iteller.kl.java.lang.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/5
 * description:
 * 调用需要在synchronized中,需要先获取目标对象的独享监视器
 * wait会释放锁，sleep不会,
 * 类比监控对象上有两个队列，等待队列和准备获取锁的队列(有资格竞争锁)
 */
public class WaitNotifyTest {

    static Object monitorObj = new Object();

    public static class WaitThread extends Thread{

        @Override
        public void run(){
            synchronized (monitorObj){
                System.out.println(System.currentTimeMillis() + ": t1 started.");
                try {
                    System.out.println(System.currentTimeMillis() + ": t1 wait for obj.");
                    monitorObj.wait();
                    System.out.println("this is after wait.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //not execute immediately after notify, wait until release monitor obj
                System.out.println(System.currentTimeMillis() + ": t1 end.");
            }
        }
    }

    public static class NotifyThread extends Thread{

        @Override
        public void run(){
            synchronized (monitorObj){
                try{
                    System.out.println(System.currentTimeMillis() + ": t2 started, notify monitor obj.");
                    monitorObj.notify();
                    System.out.println(System.currentTimeMillis() + ": t2 end.");
                    TimeUnit.SECONDS.sleep(2);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args){
        new WaitThread().start();

        new NotifyThread().start();
    }
}
