package com.iteller.kl.java.util.concurrent.demo.result;

import java.util.concurrent.*;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class ExecutorServiceResult {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        Future<Integer> future = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        service.shutdown();

        System.out.println(future.get());
    }
}
