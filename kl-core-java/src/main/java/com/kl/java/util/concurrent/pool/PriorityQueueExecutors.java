package com.kl.java.util.concurrent.pool;

import java.util.concurrent.*;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 16:21
 * description:
 */
public class PriorityQueueExecutors {

    public static class Task implements Runnable, Comparable<Task>{

        private int i;
        private String name;

        public Task(int i, String name){
            this.i = i;
            this.name = name;
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(o.i, this.i);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "处理:" + this.name);
        }
    }


    public static void main(String[] args){
        ExecutorService  executor = new ThreadPoolExecutor(1,
                1,
                60L, TimeUnit.SECONDS,
                new PriorityBlockingQueue<>());

        for(int i=0; i<10; i++){
            executor.execute(new Task(i, i + "name"));
        }

        for(int i=100; i>90; i--){
            executor.execute(new Task(i, i + "name"));
        }
        executor.shutdown();
    }
}
