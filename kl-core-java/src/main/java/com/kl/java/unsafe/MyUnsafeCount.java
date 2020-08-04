package com.kl.java.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/8 19:21
 * description:
 */
public class MyUnsafeCount {

    private static Unsafe unsafe;

    private static int count;

    private static long countOffset;

    static{
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            Field countField = MyUnsafeCount.class.getDeclaredField("count");
            //获取偏移量
           countOffset =  unsafe.staticFieldOffset(countField);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间:" + startTime);
        int threadSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for(int i=0; i<threadSize; i++){
            Thread thread = new Thread(() -> {
                    try {
                        for(int j=0; j<10; j++){
                            request();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                    }
            });
            thread.start();
        }

        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:" + (endTime - startTime) + " ms, count:" + count);
    }

    private static void request() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        unsafe.getAndAddInt(MyUnsafeCount.class, countOffset, 1);
    }
}
