package com.iteller.kl.java.lang.threadlocal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 9:28
 * description:“该类提供了线程局部 (thread-local) 变量。这些变量不同于它们的普通对应物，
 * 因为访问某个变量（通过其 get 或 set 方法）的每个线程都有自己的局部变量，它独立于变量的初始化副本。
 * ThreadLocal 实例通常是类中的 private static 字段，它们希望将状态与某一个线程（例如，用户 ID 或事务 ID）相关联。”
 */
public class MyThreadLocal {

    static ThreadLocal<String> traceIdTreadLocal = new ThreadLocal<>();

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
        for(String s : data){
            log("invoke dao " + s + " success");
        }
    }
}
