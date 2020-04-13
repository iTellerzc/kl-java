package com.iteller.kl.java.util.concurrent.queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 14:11
 * description:
 * 同步阻塞队列，SynchronousQueue没有容量，与其他BlockingQueue不同，
 * SynchronousQueue是一个不存储元素的BlockingQueue，每一个put操作必须要等待一个take操作，
 * 否则不能继续添加元素，反之亦然
 */
public class MySynchronousQueue {

    static SynchronousQueue<String> queue = new SynchronousQueue<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() ->{
            try{
                long startTime = System.currentTimeMillis();
                //blocking
                queue.put("java core");
                long endTime = System.currentTimeMillis();
                System.out.println(String.format("[%s, %s, put耗时%s], %s",
                        startTime, endTime, (endTime-startTime), Thread.currentThread().getName()));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(5);
        System.out.println(System.currentTimeMillis() + "调用take获取并删除该元素:" + queue.take());
    }
}
