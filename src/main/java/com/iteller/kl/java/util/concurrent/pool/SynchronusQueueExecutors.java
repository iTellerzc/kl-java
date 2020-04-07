package com.iteller.kl.java.util.concurrent.pool;

import java.util.concurrent.*;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 16:03
 * description:
 */
public class SynchronusQueueExecutors {

    static ExecutorService  executor = Executors.newCachedThreadPool();

    public static void main(String[] args){

        for(int i=1; i<=50; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "处理完毕！");
                }
            });
        }

        executor.shutdown();
    }
}
