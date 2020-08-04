package com.kl.java.util.concurrent.pool;

import java.util.concurrent.*;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 16:03
 * description:
 */
public class RejectionExceptionHandlerExecutors {

    public static class Task implements  Runnable{

        private String name;

        public Task(String name){
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "处理" + this.name);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
                1,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("无法处理的任务:" + r.toString());
                    }
                });

        for(int i=1; i<=10; i++){
            executor.execute(new Task("task-" + i));
        }

        executor.shutdown();
    }
}
