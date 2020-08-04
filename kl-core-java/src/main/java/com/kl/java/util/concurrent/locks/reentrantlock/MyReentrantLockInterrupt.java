package com.kl.java.util.concurrent.locks.reentrantlock;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/3/30 10:05
 * description:
 */
public class MyReentrantLockInterrupt {

    public static ReentrantLock lock1 = new ReentrantLock(false);
    public static ReentrantLock lock2 = new ReentrantLock(false);

    public static class InnerThread extends Thread{

        private int lock;

        private String name;

        private int sleep = 1;

        public InnerThread(String name, int lock){
            super(name);
            this.name = name;
            this.lock = lock;
        }

        @Override
        public void run(){
            try{
                System.out.println("lock seq:" +lock + ", currentThreadName:" + name);
                if(lock == 1){
                    System.out.println("1-1,currentTime:" + new Date() + ",lock1 is locked before:" + lock1.isLocked() + ",held by current thread:" + name +":"+ lock1.isHeldByCurrentThread());
                    lock1.lockInterruptibly();//block
                    //lock1.lock();
                    System.out.println("1-2,currentTime:" + new Date() +",lock1 is locked after:" + lock1.isLocked() + ",held by current thread:" + name +":"+ lock1.isHeldByCurrentThread());
                    TimeUnit.SECONDS.sleep(sleep);
                    System.out.println("1-3,currentTime:" + new Date() +",lock2 is locked before:" + lock2.isLocked() + ",held by current thread:" + name +":"+ lock2.isHeldByCurrentThread());
                    lock2.lockInterruptibly();
                    //lock2.lock();
                    System.out.println("1-4,currentTime:" + new Date() +",lock2 is locked after:" + lock2.isLocked() + ",held by current thread:" + name +":"+ lock2.isHeldByCurrentThread());
                }else if(lock == 2){
                    System.out.println("2-1,currentTime:" + new Date() +",lock2 is locked before:" + lock2.isLocked() +",held by current thread:" + name +":"+ lock2.isHeldByCurrentThread());
                    lock2.lockInterruptibly();
                    //lock2.lock();
                    System.out.println("2-2,currentTime:" + new Date() +",lock2 is locked after:" + lock2.isLocked() + ",held by current thread:" + name +":"+ lock2.isHeldByCurrentThread());
                    TimeUnit.SECONDS.sleep(sleep);
                    System.out.println("2-3,currentTime:" + new Date() +",lock1 is locked before:" + lock1.isLocked() + ",held by current thread:" + name +":"+ lock1.isHeldByCurrentThread());
                    lock1.lockInterruptibly();//block
                    //lock1.lock();
                    System.out.println("2-4,currentTime:" + new Date() +",lock1 is locked after:" + lock1.isLocked() + ",held by current thread:" + name +":"+ lock1.isHeldByCurrentThread());
                }
            }catch (InterruptedException e){
                System.out.println("当前:" + name + ", 线程中断标志:" + currentThread().isInterrupted() + ",currentTime:" + new Date());
                e.printStackTrace();
            }finally {
                System.out.println("why block cause run in main thread!");
                if(lock1.isHeldByCurrentThread()){
                    System.out.println("1-5:unlock, currentTime:" + new Date() + ",currentThread:" + name);
                    lock1.unlock();
                }
                if(lock2.isHeldByCurrentThread()){
                    System.out.println("2-5:unlock, currentTime:" + new Date() + ",currentThread:" + name);
                    lock2.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InnerThread t1 = new InnerThread("t1", 1);
        InnerThread t2 = new InnerThread("t2", 2);

        /*System.out.println(t1.getName() + " is alive:" + t1.isAlive());
        System.out.println(t2.getName()+ " is alive:" + t2.isAlive());
        System.out.println(Thread.currentThread().getName() + " is alive:" + Thread.currentThread().isAlive());*/

        t1.start();
        t2.start();

        TimeUnit.SECONDS.sleep(5);

        //t1.interrupt();
        t2.interrupt();

        /*System.out.println(t1.getName() + " is alive:" + t1.isAlive());
        System.out.println(t2.getName()+ " is alive:" + t2.isAlive());
        System.out.println(Thread.currentThread().getName() + " is alive:" + Thread.currentThread().isAlive());*/
    }
}
