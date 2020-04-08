package com.iteller.kl.java.util.concurrent.executors.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 19:15
 * description:
 */
public class MyScheduledThreadPoolExecutor {

    public  static void main(String[] args) throws InterruptedException {
        System.out.println("current time:" + System.currentTimeMillis());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        //delayOnce(executor);
        //delayWithFixRate(executor);

        //scheuleWithFixRate(executor);

        //scheduleError(executor);

        scheuleWithFixRateWithCancel(executor);

        //executor.shutdown();
    }

    private static void scheuleWithFixRateWithCancel(ScheduledExecutorService executor) throws InterruptedException {
        ScheduledFuture scheduledFuture = scheuleWithFixRate(executor);

        TimeUnit.SECONDS.sleep(5);
        System.out.println("isDone:" + scheduledFuture.isDone());
        System.out.println("isCancelled:" + scheduledFuture.isCancelled());
        scheduledFuture.cancel(false);
        System.out.println("isDone:" + scheduledFuture.isDone());
        System.out.println("isCancelled:" + scheduledFuture.isCancelled());
    }

    /**
     * 任务中有个1/0的操作，会触发异常，发生异常之后没有任何现象，被ScheduledExecutorService内部给吞掉了，
     * 然后这个任务再也不会执行了，scheduledFuture.isDone()输出true，表示这个任务已经结束了，再也不会被执行了。
     * 所以如果程序有异常，开发者自己注意处理一下，不然跑着跑着发现任务怎么不跑了，也没有异常输出。
     * @param executor
     * @throws InterruptedException
     */
    private static void scheduleError(ScheduledExecutorService executor) throws InterruptedException {
        final AtomicLong atomicLong = new AtomicLong(1);
        ScheduledFuture scheduledFuture = executor.scheduleAtFixedRate(()->{
            long currentCount = atomicLong.getAndIncrement();
            System.out.println(System.currentTimeMillis() + ", "+ Thread.currentThread().getName() + ",开始第" + currentCount + "次执行！");
            System.out.println(1/0);
            System.out.println(System.currentTimeMillis() + ", "+ Thread.currentThread().getName() + ",第" + currentCount + "次执行结束！");
        },1, 2, TimeUnit.SECONDS );

        TimeUnit.SECONDS.sleep(5);
        System.out.println("isDone:" + scheduledFuture.isDone());
        System.out.println("isCancelled:" + scheduledFuture.isCancelled());
    }

    /**
     *   第1次：T1+initialDelay
         第2次：T1+initialDelay+period
         第3次：T1+initialDelay+2*period
         第n次：T1+initialDelay+(n-1)*period
     * @param executor
     */
    private static ScheduledFuture scheuleWithFixRate(ScheduledExecutorService executor) {
        final AtomicLong atomicLong = new AtomicLong(1);
        ScheduledFuture scheduledFuture = executor.scheduleAtFixedRate(()->{
            long currentCount = atomicLong.getAndIncrement();
            System.out.println(System.currentTimeMillis() + ", "+ Thread.currentThread().getName() + ",开始第" + currentCount + "次执行！");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + ", "+ Thread.currentThread().getName() + ",第" + currentCount + "次执行结束！");
        },1, 2, TimeUnit.SECONDS );
        return scheduledFuture;
    }

    /**
     假设系统调用scheduleAtFixedRate的时间是T1，那么执行时间如下：
     第1次：T1+initialDelay，执行结束时间：E1
     第2次：E1+period，执行结束时间：E2
     第3次：E2+period，执行结束时间：E3
     第4次：E3+period，执行结束时间：E4
     第n次：上次执行结束时间+period
     * @param executor
     */
    private static void delayWithFixRate(ScheduledExecutorService executor) {
        final AtomicLong atomicLong = new AtomicLong(1);
        executor.scheduleWithFixedDelay(()->{
            long currentCount = atomicLong.getAndIncrement();
            System.out.println(System.currentTimeMillis() + ", "+ Thread.currentThread().getName() + ",开始第" + currentCount + "次执行！");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + ", "+ Thread.currentThread().getName() + ",第" + currentCount + "次执行结束！");
        },1, 3, TimeUnit.SECONDS );
    }

    private static void delayOnce(ScheduledExecutorService executor) {
        executor.schedule(()->{
            System.out.println("start execute:" + System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish time:" + System.currentTimeMillis());
        }, 2, TimeUnit.SECONDS);
    }
}
