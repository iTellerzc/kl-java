package com.kl.java.util.concurrent.locks.deadlock;

/**
 * @author iTeller_zc
 * date:2020/4/4
 * description:
 */
public class DeadLockTest {

    public static void main(String[] args){
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread t1 = new Thread(new DeadLock(obj1, obj2, 1, 2, true));
        Thread t2 = new Thread(new DeadLock(obj1, obj2, 2, 1, false));

        t1.setName("thread1");
        t1.start();

        t2.setName("thread2");
        t2.start();
    }
}
