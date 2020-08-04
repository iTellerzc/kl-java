package com.kl.java.util.concurrent.collection.queue.block;

import java.io.Serializable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 14:10
 * description:
 * 一个支持优先级排序的无界阻塞队列，进入队列的元素会按照优先级进行排序
 */
public class MyPriorityBlockingQueue {

    public static class Msg implements Comparable<Msg>, Serializable{

        private static final long serialVersionUID = -1458801623865876879L;

        private int priority;

        private String msg;

        public Msg(int priority, String msg){
            this.priority = priority;
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "Msg{" +
                    "priority=" + priority +
                    ", msg='" + msg + '\'' +
                    '}';
        }


        @Override
        public int compareTo(Msg msg) {
            return Integer.compare(this.priority, msg.priority);
        }
    }

    static PriorityBlockingQueue<Msg> pushQueue = new PriorityBlockingQueue(5);

    public static void pushMsg(Msg msg){
        pushQueue.offer(msg);
    }

    static{
        new Thread(() -> {
            while(true){
                Msg msg;
                try {
                    long startTime = System.currentTimeMillis();
                    //blocking
                    msg = pushQueue.take();
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

    public static void main(String[] args){
        for(int i=5; i>0; i--){
            pushMsg(new Msg(i, "keep learn core java " + i +" day"));
        }
    }
}
