package com.iteller.kl.java.util.concurrent.future;

import java.util.concurrent.*;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 20:18
 * description:
 */
public class MyFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> result = executorService.submit(()->{
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName()+",start!");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName()+",end!");
            return 10;
        });
        System.out.println(System.currentTimeMillis() + ", " + Thread.currentThread().getName());
        //block
        System.out.println(System.currentTimeMillis() +"," + Thread.currentThread().getName()+", result:" + result.get());

        executorService.shutdown();
    }
}
