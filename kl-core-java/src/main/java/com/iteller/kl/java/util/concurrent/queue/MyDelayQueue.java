package com.iteller.kl.java.util.concurrent.queue;

import java.util.Calendar;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 14:11
 * description:
 * DelayQueue是一个支持延时获取元素的无界阻塞队列，里面的元素全部都是“可延期”的元素，
 * 列头的元素是最先“到期”的元素，如果队列里面没有元素到期，是不能从列头获取元素的，
 * 哪怕有元素也不行，也就是说只有在延迟期到时才能够从队列中取元素
 */
public class MyDelayQueue {
    public static class Msg implements Delayed{

        private int priority;

        private String msg;

        private long sendTime;

        public Msg(int priority, String msg, long sendTime){
            this.priority = priority;
            this.msg = msg;
            this.sendTime = sendTime;
        }

        @Override
        public String toString() {
            return "Msg{" +
                    "priority=" + priority +
                    ", msg='" + msg + '\'' +
                    ", sendTime=" + sendTime +
                    '}';
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(sendTime - Calendar.getInstance().getTimeInMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if(o instanceof Msg){
                Msg msg = (Msg) o;
                return Integer.compare(this.priority, ((Msg) o).priority);
            }
            return 0;
        }
    }

    static DelayQueue<Msg> pushQueue = new DelayQueue<>();

    public static void pushMsg(Msg msg){
        pushQueue.offer(msg);
    }

    static{
        new Thread(() -> {
            while(true){
                Msg msg;
                try {
                    //blocking
                    msg = pushQueue.take();
                    long endTime = System.currentTimeMillis();
                    //mock push
                    TimeUnit.MICROSECONDS.sleep(500);
                    System.out.println(String.format("[定时发送时间:%s, 实际发送时间:%s, 发送消息:%s",
                            msg.sendTime, endTime, msg));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args){
        System.out.println("ms:" + System.currentTimeMillis());
        System.out.println("calendar ms:" + Calendar.getInstance().getTimeInMillis());
        for(int i=5; i>0; i--){
            pushMsg(new Msg(i, "keep learn core java " + i +" day", Calendar.getInstance().getTimeInMillis() + i *2000));
        }
    }
}
