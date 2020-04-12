package com.iteller.kl.java.util.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 20:05
 * description:
 */
public class MyExecutors {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i=0; i<10; i++){
            executorService.execute(()->{
                try {
                    System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + "开始执行.");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();

    }
}
