package com.kl.java.util.concurrent.locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 11:50
 * description:
 */
public class NumAdd {

    private static int num = 0;

    private static ReentrantLock lock = new ReentrantLock(false);

    private static void add(){
        lock.lock();
        //lock.lock(); 可重入锁
        try{
            num++;
        }finally {
            lock.unlock();
            //lock.unlock();
        }
    }

    public static class T extends Thread{

        @Override
        public void run(){
            for(int i=0; i<1000; i++){
                NumAdd.add();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        T t2 = new T();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(num);
    }
}
