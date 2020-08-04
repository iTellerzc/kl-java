package com.kl.java.util.concurrent.locks.deadlock.starvation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author iTeller_zc
 * date:2020/4/4
 * description:
 */
public class StarvationLockTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        StarvationLock starvationLock = new StarvationLock(executorService);

        Future<String> result = executorService.submit(starvationLock);
        System.out.println(result.get());

        System.out.println("over");
        executorService.shutdown();
    }
}
