package com.kl.java.obj;

import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 14:54
 * description:
 */
public class ObjWaitNotify {

    private static Object lock = new Object();

    public static class WaitThread extends Thread{

        @Override
        public void run(){
            System.out.println(System.currentTimeMillis() + ", " + getName() + "准备获取锁");
            synchronized (lock){
                try {
                    System.out.println(System.currentTimeMillis() + ", " + getName() + "成功获取锁");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(System.currentTimeMillis() + ", " + getName() + "释放锁");
        }
    }

    public static class NotifyThread extends Thread{

        @Override
        public void run(){
            System.out.println(System.currentTimeMillis() + ", " + getName() + "准备获取锁");
            synchronized (lock){
                System.out.println(System.currentTimeMillis() + ", " + getName() + "成功获取锁");
                lock.notify();
                System.out.println(System.currentTimeMillis() + ", " + getName() + " notify");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ", " + getName() + "准备释放获取锁");
            }
            System.out.println(System.currentTimeMillis() + ", " + getName() + "释放锁");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitThread waitThread = new WaitThread();
        waitThread.setName("waitThread");
        waitThread.start();

        TimeUnit.SECONDS.sleep(5);

        NotifyThread notifyThread = new NotifyThread();
        notifyThread.setName("notifyThread");
        notifyThread.start();
    }
}
