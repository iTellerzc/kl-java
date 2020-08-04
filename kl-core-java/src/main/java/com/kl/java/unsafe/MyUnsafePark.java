package com.kl.java.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/8 19:21
 * description:
 */
public class MyUnsafePark {

    private static Unsafe unsafe;

    static{
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        m1();
        //m2();
    }

    private static void m1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(System.currentTimeMillis() + ", " + Thread.currentThread().getName() + " start.");
            unsafe.park(false, 0);//0 means wait until unpark
            System.out.println(System.currentTimeMillis() + ", " + Thread.currentThread().getName() + " end.");

        });
        thread.setName("t1");
        thread.start();

        TimeUnit.SECONDS.sleep(5);
        unsafe.unpark(thread);
    }

    /**
     * 阻塞指定时间
     */
    private static void m2() {
        Thread thread = new Thread(() -> {
            System.out.println(System.currentTimeMillis() + ", " + Thread.currentThread().getName() + " start.");
            //挂起线程
            unsafe.park(false, TimeUnit.SECONDS.toNanos(2));
            System.out.println(System.currentTimeMillis() + ", " + Thread.currentThread().getName() + " end.");
        });
        thread.setName("t2");
        thread.start();
    }

}
