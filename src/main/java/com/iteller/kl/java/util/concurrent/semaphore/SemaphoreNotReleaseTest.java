package com.iteller.kl.java.util.concurrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 9:30
 * description:
 */
public class SemaphoreNotReleaseTest {

    static Semaphore semaphore = new Semaphore(5);

    public static class T extends Thread{

        public T(String name){
            super(name);
        }

        @Override
        public void run(){
            Thread currentThread = currentThread();
            try {
                //等待
                semaphore.acquire();
                System.out.println(System.currentTimeMillis() + ", " + currentThread.getName() + " 获取许可");
                //阻塞
                TimeUnit.SECONDS.sleep(3);

                System.out.println(System.currentTimeMillis() + ", " + currentThread.getName() + "运行结束");
                System.out.println("可以被获得的许可：" + semaphore.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }/*finally {
                //dangerous if not release
                semaphore.release();
                System.out.println(System.currentTimeMillis() + ", " + currentThread.getName() + " 释放许可");
            }*/
        }
    }


    public static void main(String[] args){
        for(int i=0; i<10; i++){
            new T(i + "-thread").start();
        }
    }
}
