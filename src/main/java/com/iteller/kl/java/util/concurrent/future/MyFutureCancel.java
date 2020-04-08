package com.iteller.kl.java.util.concurrent.future;

import java.util.concurrent.*;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 20:18
 * description:
 */
public class MyFutureCancel {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> result = executorService.submit(()->{
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName()+",start!");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName()+",end!");
            return 4;
        });
        System.out.println(System.currentTimeMillis() + ", " + Thread.currentThread().getName());
        result.cancel(false);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("done:" + result.isDone() + ", cancelled:" + result.isCancelled());

        try{
            System.out.println(System.currentTimeMillis() +"," + Thread.currentThread().getName()+", result:" + result.get());
        }catch (Exception e){
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
