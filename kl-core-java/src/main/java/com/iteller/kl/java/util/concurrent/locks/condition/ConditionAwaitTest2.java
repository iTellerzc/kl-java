package com.iteller.kl.java.util.concurrent.locks.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 15:26
 * description:
 */
public class ConditionAwaitTest2 {

    static ReentrantLock lock = new ReentrantLock(false);
    static Condition condition = lock.newCondition();

    public static class T extends Thread{

        @Override
        public void run(){
            lock.lock();
            try {
                System.out.println(System.currentTimeMillis() + ", " + getName() + " start");
                boolean r = condition.await(2, TimeUnit.SECONDS);
                //t1线程等待2秒之后，自动返回继续执行，最后await方法返回false，await返回false表示超时之后自动返回
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
        t.setName("awaitThread");
        t.start();

        //TimeUnit.SECONDS.sleep(3);
    }
}
