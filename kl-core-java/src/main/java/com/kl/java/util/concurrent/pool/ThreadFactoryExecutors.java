package com.kl.java.util.concurrent.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 16:03
 * description:
 */
public class ThreadFactoryExecutors {

    static AtomicInteger id = new AtomicInteger(1);

    public static void main(String[] args){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("defined thread factory pool-" + id.getAndIncrement());
                        return thread;
                    }
                },
                new ThreadPoolExecutor.AbortPolicy());

        for(int i=1; i<=10; i++){
            final int j=i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "处理：" + "任务-" + j);
                }
            });
        }

        executor.shutdown();
    }
}
