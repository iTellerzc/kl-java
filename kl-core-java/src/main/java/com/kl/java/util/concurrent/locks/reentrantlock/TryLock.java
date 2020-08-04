package com.kl.java.util.concurrent.locks.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 14:18
 * description:
 */
public class TryLock {

    private static ReentrantLock lock = new ReentrantLock(false);

    public static class T extends Thread{

        public T(String name){
            super(name);
        }

        @Override
        public void run(){
            try{
                System.out.println(System.currentTimeMillis() + ", thread name:" + getName() + "开始获取锁.");
                //无阻塞 立即响应
                if(lock.tryLock()){
                    System.out.println(System.currentTimeMillis() + ", thread name:" + getName() + "获取锁成功.");
                    TimeUnit.SECONDS.sleep(5);
                }else{
                    System.out.println(System.currentTimeMillis() + ", thread name:" + getName() + "获取锁失败.");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                if(lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T("t1");
        T t2 = new T("t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
