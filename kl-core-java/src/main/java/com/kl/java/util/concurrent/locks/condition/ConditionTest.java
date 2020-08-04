package com.kl.java.util.concurrent.locks.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 15:08
 * description:
 */
public class ConditionTest {

    private static ReentrantLock lock = new ReentrantLock(false);

    private static Condition condition = lock.newCondition();

    public static class WaitThread extends Thread{

        @Override
        public void run(){
            System.out.println(System.currentTimeMillis() + ", " + getName() + "准备获取锁");
            lock.lock();
            try{
                System.out.println(System.currentTimeMillis() + ", " + getName() + "成功获取锁");
                condition.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            System.out.println(System.currentTimeMillis() + ", " + getName() + "释放锁");
        }
    }


    public static class NotifyThread extends Thread{

        @Override
        public void run(){
            System.out.println(System.currentTimeMillis() + ", " + getName() + "准备获取锁");
            lock.lock();
            try{
                System.out.println(System.currentTimeMillis() + ", " + getName() + "成功获取锁");
                condition.signal();
                System.out.println(System.currentTimeMillis() + ", " + getName() + " signal");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ", " + getName() + "准备释放锁");
            }finally {
                lock.unlock();
            }
            System.out.println(System.currentTimeMillis() + ", " + getName() + "释放锁");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitThread waitThread = new WaitThread();
        waitThread.setName("waitCondition");
        waitThread.start();

        TimeUnit.SECONDS.sleep(5);

        NotifyThread notifyThread = new NotifyThread();
        notifyThread.setName("notifyCondition");
        notifyThread.start();
    }
}
