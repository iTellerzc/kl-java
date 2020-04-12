package com.iteller.kl.java.util.concurrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 9:30
 * description:
 */
public class SemaphoreCorrectInterrupt {

    static Semaphore semaphore = new Semaphore(1);

    public static class T extends Thread{

        public T(String name){
            super(name);
        }

        @Override
        public void run(){
            Thread currentThread = currentThread();
            boolean acquireSuccess = false;
            try {
                //等待
                semaphore.acquire();
                acquireSuccess = true;
                System.out.println(System.currentTimeMillis() + ", " + currentThread.getName() + "获取许可"+", 可以被获得的许可：" + semaphore.availablePermits());
                //阻塞
                TimeUnit.SECONDS.sleep(15);

                System.out.println(System.currentTimeMillis() + ", " + currentThread.getName() + "运行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //dangerous if not release
                if(acquireSuccess){
                    semaphore.release();
                }
            }
            System.out.println(System.currentTimeMillis() +", "+currentThread.getName() +"释放后, 可以被获得的许可：" + semaphore.availablePermits());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        T t1 = new T("t1");
        T t2 = new T("t2");
        T t3 = new T("t3");

        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t3.start();

        t3.interrupt();
        t2.interrupt();
    }
}
