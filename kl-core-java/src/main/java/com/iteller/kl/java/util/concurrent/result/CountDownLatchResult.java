package com.iteller.kl.java.util.concurrent.result;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class CountDownLatchResult {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        final Result<Integer> result = new Result<>();

        Thread thread = new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(2);
                result.setResult(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        });
        thread.start();

        countDownLatch.await();
        System.out.println(result.getResult());
    }
}
