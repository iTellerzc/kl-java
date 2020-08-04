package com.kl.java.util.concurrent.google;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class BatchFutureResultCallBack {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService delegate = Executors.newFixedThreadPool(5);

        ListeningExecutorService executorService =  MoreExecutors.listeningDecorator(delegate);

        List<ListenableFuture<Integer>> futureList = new ArrayList();

        for(int i=0; i<=5; i++){
            int j = i;
            futureList.add(executorService.submit(() -> {
                TimeUnit.SECONDS.sleep(j);
                return j;
            }));
        }

        List<Integer> resultList = Futures.allAsList(futureList).get();

        resultList.forEach(item -> {
            System.out.println(item);
        });


        executorService.shutdown();
    }
}
