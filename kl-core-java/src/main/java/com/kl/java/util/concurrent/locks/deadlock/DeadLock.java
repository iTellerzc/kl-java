package com.kl.java.util.concurrent.locks.deadlock;

/**
 * @author iTeller_zc
 * date:2020/4/4
 * description:
 */
public class DeadLock implements Runnable {

    Object obj1;

    Object obj2;

    int a, b;
    boolean flag;

    public DeadLock(Object obj1, Object obj2, int a, int b, boolean flag){
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.a = a;
        this.b = b;
        this.flag = flag;

    }


    @Override
    public void run() {
        try{
            if(flag){
                synchronized (obj1){
                    System.out.println(Thread.currentThread().getName() +" sync obj1.");
                    Thread.sleep(100);
                    synchronized (obj2){
                        System.out.println(Thread.currentThread().getName() +" sync obj2.");
                        System.out.println(a + b);
                    }
                }
            }else{
                synchronized (obj2){
                    System.out.println(Thread.currentThread().getName() +" sync obj2.");
                    Thread.sleep(100);
                    synchronized (obj1){
                        System.out.println(Thread.currentThread().getName() +" sync obj1.");
                        System.out.println(a + b);
                    }
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
