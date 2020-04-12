package com.iteller.kl.java.util.concurrent.locks.condition;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 15:26
 * description:
 */
public class ConditionAwaitUtil {

    static ReentrantLock lock = new ReentrantLock(false);
    static Condition condition = lock.newCondition();

    public static class T extends Thread{

        @Override
        public void run(){
            lock.lock();
            try {
                System.out.println(System.currentTimeMillis() + ", " + getName() + " start");
                boolean r= condition.awaitUntil(new Date(System.currentTimeMillis() + 5000));
                System.out.println("await result:" + r);
                System.out.println(System.currentTimeMillis() + ", " + getName() + " end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("awaitUtilTread");
        t.start();

        /*TimeUnit.SECONDS.sleep(1);
        lock.lock();
        try{
            condition.signal();
        }finally {
            lock.unlock();

        }*/
    }
}
