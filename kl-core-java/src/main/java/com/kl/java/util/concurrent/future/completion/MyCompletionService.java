package com.kl.java.util.concurrent.future.completion;

import java.util.concurrent.*;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/8 9:23
 * description:
 * ExecutorCompletionService创建的时候会传入一个线程池，
 * 调用submit方法传入需要执行的任务，任务由内部的线程池来处理；
 * ExecutorCompletionService内部有个阻塞队列，任意一个任务完成之后，会将任务的执行结果（Future类型）放入阻塞队列中，
 * 然后其他线程可以调用它take、poll方法从这个阻塞队列中获取一个已经完成的任务，获取任务返回结果的顺序和任务执行完成的先后顺序一致，
 * 所以最先完成的任务会先返回。
 */
public class MyCompletionService {

    public static class GoodsModel{
        private String name;

        private long orderTime;

        private long sendTime;

        public GoodsModel(String name, long orderTime, long sendTime){
            this.name = name;
            this.orderTime = orderTime;
            this.sendTime = sendTime;
        }

        @Override
        public String toString() {
            return "GoodsModel{" +
                    "name='" + name + '\'' +
                    ", orderTime=" + orderTime +
                    ", sendTime=" + sendTime +
                    '}';
        }
    }

    static void moveUp(GoodsModel goodsModel) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println(System.currentTimeMillis() + ", 将物品搬上楼:" + goodsModel);
    }

    static Callable<GoodsModel> order(String name, long costTime){
        return (()->{
            long startTime = System.currentTimeMillis();
            System.out.println(startTime + ",购买商品" + name + "下单");
            TimeUnit.SECONDS.sleep(costTime);
            long endTime = System.currentTimeMillis();
            System.out.println(System.currentTimeMillis() + ", 购买商品：" + name + ", 下单配送花费:" + (endTime-startTime) + " ms");
            return new GoodsModel(name, startTime, endTime);
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime + ", 开始购物---");

        //创建任务线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //创建ExecutorCompletionService
        ExecutorCompletionService<GoodsModel> executorCompletionService = new ExecutorCompletionService(executorService);

        //异步下单
        executorCompletionService.submit(order("洗衣机", 5L));

        executorCompletionService.submit(order("冰箱", 10L));

        executorService.shutdown();

        int goodsCount = 2;
        //block
        for(int i=0; i < goodsCount; i++){
            GoodsModel goodsModel = executorCompletionService.take().get();
            moveUp(goodsModel);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("购物已完成, 耗时:" + (endTime-startTime) + "ms");
    }
}
