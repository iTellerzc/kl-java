package com.iteller.kl.java.util.concurrent.pool;

import java.util.concurrent.*;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 16:48
 * description:
 * 要想合理的配置线程池，需要先分析任务的特性，可从以下几个角度分析：
 * 任务的性质：CPU密集型任务、IO密集型任务和混合型任务
 * 任务的优先级：高、中、低
 * 任务的执行时间：长、中、短
 * 任务的依赖性：是否依赖其他的系统资源，如数据库连接。
 * 性质不同任务可以用不同规模的线程池分开处理。CPU密集型任务应该尽可能小的线程，如配置cpu数量+1个线程的线程池。
 * 由于IO密集型任务并不是一直在执行任务，不能让cpu闲着，则应配置尽可能多的线程，如：cup数量*2。
 * 混合型的任务，如果可以拆分，将其拆分成一个CPU密集型任务和一个IO密集型任务，只要这2个任务执行的时间相差不是太大，
 * 那么分解后执行的吞吐量将高于串行执行的吞吐量。可以通过Runtime.getRuntime().availableProcessors()方法获取cpu数量。
 * 优先级不同任务可以对线程池采用优先级队列来处理，让优先级高的先执行。
 * 使用队列的时候建议使用有界队列，有界队列增加了系统的稳定性，如果采用无界队列，任务太多的时候可能导致系统OOM，直接让系统宕机。
 * 线程池中总线程大小对系统的性能有一定的影响，我们的目标是希望系统能够发挥最好的性能，过多或者过小的线程数量无法有效的使用机器的性能。
 * 在Java Concurrency in Practice书中给出了估算线程池大小的公式：
 * Ncpu = CUP的数量
 * Ucpu = 目标CPU的使用率，0<=Ucpu<=1
 * W/C = 等待时间与计算时间的比例
 * 为保存处理器达到期望的使用率，最优的线程池的大小等于：
 * Nthreads = Ncpu × Ucpu × (1+W/C)
 */
public class ExtExecutors {

    public static class Task implements  Runnable{

        private String name;

        public Task(String name){
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "处理" + this.name);
            try {
                TimeUnit.SECONDS.sleep(2);
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
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                            System.out.println("无法处理的任务:" + r.toString());
                    }
                }){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println(System.currentTimeMillis() + ", " + t.getName() + " 开始执行:" + r.toString());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println(System.currentTimeMillis() + ", 执行完毕:" + r.toString());
            }

            @Override
            protected void terminated() {
                System.out.println(System.currentTimeMillis() + " 关闭线程池" );
            }
        };

        for(int i=1; i<10; i++){
            executor.execute(new Task("name-" + i));
        }
    }
}
