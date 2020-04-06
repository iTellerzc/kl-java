package com.iteller.kl.java.util.concurrent.locks.support;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 16:59
 * description:
 * 每个线程都有一个许可(permit)，permit只有两个值1和0，默认是0。
    当调用unpark(thread)方法，就会将thread线程的许可permit设置成1(注意多次调用unpark方法，不会累加，permit值还是1)。
    当调用park()方法，如果当前线程的permit是1，那么将permit设置为0，并立即返回。如果当前线程的permit是0，那么当前线程就会阻塞，直到别的线程将当前线程的permit设置为1时，park方法会被唤醒，然后会将permit再次设置为0，并返回。
    注意：因为permit默认是0，所以一开始调用park()方法，线程必定会被阻塞。调用unpark(thread)方法后，会自动唤醒thread线程，即park方法立即返回。
 */
public class LockSupportTest {

    public static class T extends Thread{

        @Override
        public void run(){
            System.out.println(System.currentTimeMillis() + ", " + currentThread().getName() + " start");
            LockSupport.park();
            System.out.println(System.currentTimeMillis() + ", " + currentThread().getName() + "被唤醒");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("lockSupportThread");
        t.start();

        TimeUnit.SECONDS.sleep(3);

        LockSupport.unpark(t);
        System.out.println(System.currentTimeMillis() + ", LockSupport.unpark;执行完毕");
    }
}
