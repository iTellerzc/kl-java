package com.iteller.kl.java.util.concurrent.collection.queue.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 11:59
 * description:
 *
 * 操作类型	    抛出异常	    返回特殊值	    一直阻塞	  超时退出
    插入	     add(e)	          offer(e)	    put(e)	 offer(e,timeuout,unit)
    移除	    remove()	      poll()	    take()	 poll(timeout,unit)
    检查	    element()	      peek()	    不支持	 不支持
 *
 * 基于数组的阻塞队列实现，其内部维护一个定长的数组，用于存储队列元素。
 * 线程阻塞的实现是通过ReentrantLock来完成的，数据的插入与取出共用同一个锁，因此ArrayBlockingQueue并不能实现生产、消费同时进行。
 * 而且在创建ArrayBlockingQueue时，我们还可以控制对象的内部锁是否采用公平锁，默认采用非公平锁。
 */
public class MyArrayBlockingQueue {

    static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(100, false);

    static{
        new Thread(() -> {
            while(true){
                String msg;
                try {
                    long startTime = System.currentTimeMillis();
                    msg = queue.take();
                    long endTime = System.currentTimeMillis();
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
