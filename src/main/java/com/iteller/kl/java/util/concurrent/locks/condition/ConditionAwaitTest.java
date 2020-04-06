package com.iteller.kl.java.util.concurrent.locks.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 15:20
 * description:
 */
public class ConditionAwaitTest {

    static ReentrantLock lock = new ReentrantLock(false);
    static Condition condition = lock.newCondition();

    public static class T extends Thread{

        @Override
        public void run(){
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                System.out.println("线程中断标志:" + isInterrupted());
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("t1");
        t.start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("1.t线程中断标志:" + t.isInterrupted());
        t.interrupt();
        System.out.println("2.t线程中断标志:" + t.isInterrupted());
    }
}
