package com.iteller.kl.java.util.concurrent.demo.result;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class FutureTaskResult {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(() -> {
            TimeUnit.SECONDS.sleep(2);
            return 10;
        });

        new Thread(futureTask).start();

        System.out.println(futureTask.get());

    }
}
