package com.kl.java.util.concurrent.locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 11:55
 * description:
 */
public class FairUnFairLock {

    //private static ReentrantLock lock = new ReentrantLock(true);
    private static ReentrantLock lock = new ReentrantLock(false);

    public static class T extends Thread{

        public T(String name){
            super(name);
        }

        @Override
        public void run(){
            for(int i=0; i<5; i++){
                lock.lock();
                try{
                    System.out.println(getName() + " acquire lock.");
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T("t1");
        T t2 = new T("t2");
        T t3 = new T("t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
