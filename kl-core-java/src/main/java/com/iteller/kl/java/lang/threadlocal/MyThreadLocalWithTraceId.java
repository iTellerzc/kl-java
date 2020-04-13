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
 * description:
 */
public class MyThreadLocalWithTraceId {

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
                invokeCtr(data, traceId);
            });
        }

        requestPool.shutdown();
    }

    public static void log(String msg, String traceId){
        StackTraceElement stack[] = new Throwable().getStackTrace();
        System.out.println("---" + System.currentTimeMillis() + ", [traceId: " + traceId + "]," + stack[1] +" msg:" + msg);
    }

    private static void invokeCtr(List<String> data, String traceId) {
        log("deal ctr req.", traceId );
        invokeService(data, traceId);
    }

    private static void invokeService(List<String> data,String traceId) {
        log("deal service req.", traceId);
        invokeDao(data, traceId);
    }

    private static void invokeDao(List<String> data, String traceId) {
        log("deal dao req.", traceId);
        for(String s : data){
            log("invoke dao " + s + " success", traceId);
        }
    }
}
