package com.iteller.kl.java.util.concurrent.google;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class MyMoreExecutors2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ListeningExecutorService listeningExecutorService =  MoreExecutors.listeningDecorator(executorService);

        //异步执行任务
        ListenableFuture future = listeningExecutorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        future.addListener(() -> {
            System.out.println("执行完毕, 回调函数！");
        }, MoreExecutors.directExecutor());

        System.out.println("result:" + future.get());
        executorService.shutdown();
    }
}
