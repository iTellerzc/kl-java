package com.iteller.kl.java.lang.threadlocal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 9:28
 * description:
 */
public class MyInheritableThreadLocal {

    //static ThreadLocal<String> traceIdTreadLocal = new ThreadLocal<>();
    static InheritableThreadLocal<String> traceIdTreadLocal = new InheritableThreadLocal<>();

    static AtomicInteger threadIndex = new AtomicInteger(1);

    static ThreadPoolExecutor requestPool = new ThreadPoolExecutor(3,
            3,
            60, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(),
            r -> {
                Thread thread = new Thread(r);
                thread.setName("reqThread" + threadIndex.getAndIncrement());
                return thread;
            });

    public static void main(String[] args){
        List<String> data = new ArrayList<>();
        for(int i=0; i<3; i++){
            data.add("data " + i);
        }

        int reqCount = 5;
        for(int i=0; i < reqCount; i++){
            String traceId = String.valueOf(i);
            requestPool.execute(() ->{
                try{
                    traceIdTreadLocal.set(traceId);
                    invokeCtr(data);
                }finally {
                    //移除
                    traceIdTreadLocal.remove();
                }
            });
        }

        requestPool.shutdown();
    }

    public static void log(String msg){
        StackTraceElement stack[] = new Throwable().getStackTrace();
        String traceId = traceIdTreadLocal.get();
        System.out.println("---" + System.currentTimeMillis() + ", [traceId: " + traceId + "]," + stack[1] +" msg:" + msg);
    }

    private static void invokeCtr(List<String> data) {
        log("deal ctr req." );
        invokeService(data);
    }

    private static void invokeService(List<String> data) {
        log("deal service req.");
        invokeDao(data);
    }

    private static void invokeDao(List<String> data) {
        log("deal dao req.");
        CountDownLatch countDownLatch = new CountDownLatch(data.size());
        String threadName = Thread.currentThread().getName();
        for(String s : data){
            new Thread(() ->{
                try {
                    TimeUnit.MICROSECONDS.sleep(100);
                    log("invoke dao " + s + " success, 主线程名称:" + threadName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
