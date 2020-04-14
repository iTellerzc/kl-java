package com.iteller.kl.java.util.concurrent.result;

import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class JoinResult {

    public static void main(String[] args) throws InterruptedException {
        final Result<Integer> result =new Result();

        Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                result.setResult(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        thread.join();

        System.out.println(result.getResult());
    }
}
