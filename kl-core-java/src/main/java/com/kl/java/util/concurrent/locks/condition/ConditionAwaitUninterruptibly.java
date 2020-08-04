package com.kl.java.util.concurrent.locks.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 15:26
 * description:
 */
public class ConditionAwaitUninterruptibly {

    static ReentrantLock lock = new ReentrantLock(false);
    static Condition condition = lock.newCondition();

    public static class T extends Thread{

        @Override
        public void run(){
            lock.lock();
            try {
                System.out.println(System.currentTimeMillis() + ", " + getName() + " start");
                condition.awaitUninterruptibly();
                System.out.println(System.currentTimeMillis() + ", " + getName() + " end");
            } /*catch (InterruptedException e) {
                //not support
                e.printStackTrace();
            }*/finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("awaitUnInterruptibly");
        t.start();

        TimeUnit.SECONDS.sleep(3);
        lock.lock();
        try{
            condition.signal();
        }finally {
            lock.unlock();

        }

        //not support
        /*TimeUnit.SECONDS.sleep(2);
        t.interrupt();*/
    }
}
