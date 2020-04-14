package com.iteller.kl.java.ratelimit;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class BucketLimit {

    public static class LeakyBucketLimiter {
        static AtomicInteger threadNum = new AtomicInteger(1);

        /**
         * 漏桶容量
         */
        private int capcity;

        /**
         * 速率
         */
        private int flowRate;

        /**
         * 速率单位
         */
        private TimeUnit flowRateUnit;

        /**
         * 缓冲
         */
        private BlockingQueue<Node> queue;

        /**
         * 漏桶流出的任务时间间隔(纳秒)
         */
        private long flowRateNanosTime;

        public LeakyBucketLimiter(int capcity, int flowRate, TimeUnit flowRateUnit){
            this.capcity = capcity;
            this.flowRate = flowRate;
            this.flowRateUnit = flowRateUnit;
            this.threadWork();
        }

        private void threadWork() {

            this.queue = new ArrayBlockingQueue<Node>(capcity);
            this.flowRateNanosTime = flowRateUnit.toNanos(1) / flowRate;
            Thread thread = new Thread(this::bucketWork);//stream
            thread.setName("漏桶线程-" + threadNum.getAndIncrement());
            thread.start();
        }

        public void bucketWork(){
            while(true){
                Node node = queue.poll();
                if(Objects.nonNull(node)){
                    LockSupport.unpark(node.thread);
                }
                //sleep
                LockSupport.parkNanos(this.flowRateNanosTime);
            }
        }

        public static LeakyBucketLimiter build(int capcity, int flowRate, TimeUnit flowRateUnit){
            if(capcity < 0 || flowRate < 0){
                throw  new IllegalArgumentException("capcity, flowRate必须大于0");
            }
            return new LeakyBucketLimiter(capcity, flowRate, flowRateUnit);
        }

        public boolean acquire(){
            Thread thread = Thread.currentThread();
            Node node = new Node(thread);
            if(queue.offer(node)){
                LockSupport.park();
                return true;
            }
            return false;
        }

        class Node{
            Thread thread;

            public Node(Thread thread){
                this.thread = thread;
            }
        }

    }

    public static void main(String[] args){
        LeakyBucketLimiter leakyBucketLimiter = new LeakyBucketLimiter(10, 60, TimeUnit.MINUTES);
        for(int i=0; i<20; i++){
            new Thread(() -> {
                boolean acquire = leakyBucketLimiter.acquire();
                System.out.println(System.currentTimeMillis() + " " + acquire);
                try {
                    SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
