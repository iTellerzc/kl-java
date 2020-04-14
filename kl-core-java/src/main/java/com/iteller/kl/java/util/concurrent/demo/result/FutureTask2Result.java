package com.iteller.kl.java.util.concurrent.demo.result;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class FutureTask2Result {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(() -> {
            return 10;
        });

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            futureTask.run();
        }).start();

        System.out.println(futureTask.get());

    }
}
