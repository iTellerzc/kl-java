package com.kl.java.util.concurrent.executors;

import com.kl.java.util.concurrent.executors.thread.MyRunnable;
import com.kl.java.util.concurrent.executors.thread.MyThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * author:18060903(iTeller_zc)
 * date:2019/12/5 9:49
 * description:
 */
public class MyThreadPoolExecutors {

    public static void main(String[] args) throws InterruptedException {
       ThreadPoolExecutor tpe = new ThreadPoolExecutor(1,
               5,
               0, TimeUnit.MILLISECONDS,
               new ArrayBlockingQueue<Runnable>(14),
               new MyThreadFactory("zc-thread-pool-", false));
       for(int i = 1; i <= 20; i++){
           try{
               tpe.submit(new MyRunnable(System.currentTimeMillis(), i));
           }catch (RejectedExecutionException e){
               System.out.println("i:" + i + " reject!");
               //e.printStackTrace();
           }
       }
    }

}
