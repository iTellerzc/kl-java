package com.iteller.kl.java.util.concurrent.queue;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 14:09
 * description:
 * 基于单向链表的阻塞队列实现，在初始化LinkedBlockingQueue的时候可以指定大小，也可以不指定，
 * 默认类似一个无限大小的容量（Integer.MAX_VALUE），不指队列容量大小也是会有风险的，一旦数据生产速度大于消费速度，
 * 系统内存将有可能被消耗殆尽，因此要谨慎操作。另外LinkedBlockingQueue中用于阻塞生产者、消费者的锁是两个（锁分离），
 * 因此生产与消费是可以同时进行的。
 */
public class MyLinkedBlockingQueue {

    static LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<String>(3);

    static{
        new Thread(() -> {
            while(true){
                String msg;
                try {
                    long startTime = System.currentTimeMillis();
                    //blocking
                    msg = queue.take();
                    long endTime = System.currentTimeMillis();
                    //mock push
                    TimeUnit.MICROSECONDS.sleep(500);
                    System.out.println(String.format("[%s, %s, take耗时%s ms]，%s, 发送消息:%s",
                            startTime, endTime, (endTime-startTime), Thread.currentThread().getName(), msg));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void pushMsg(String msg){
        queue.offer(msg);
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=1; i<=5; i++){
            String msg = "keep learn core java:" + i + " day";
            //模拟耗时
            TimeUnit.SECONDS.sleep(i);
            pushMsg(msg);
        }
    }
}
