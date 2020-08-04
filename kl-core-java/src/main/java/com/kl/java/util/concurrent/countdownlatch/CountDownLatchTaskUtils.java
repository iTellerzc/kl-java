package com.kl.java.util.concurrent.countdownlatch;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 10:54
 * description:
 */
public class CountDownLatchTaskUtils {

    public static final int POOL_SIZE ;

    static {
        //System.out.println(Runtime.getRuntime().availableProcessors() + "个可用处理器");
        POOL_SIZE = Integer.max(Runtime.getRuntime().availableProcessors(), 5);
    }


    /**
     * 并行处理任务,等待结束
     * @param taskLists
     * @param consumer
     * @param <T>
     */
    public static <T> void dispose(List<T> taskLists, Consumer<T> consumer) throws InterruptedException {
        dispose(true, POOL_SIZE, taskLists, consumer);
    }

    /**
     * 线程池处理并等待结束
     * @param moreThread
     * @param poolSize
     * @param taskLists
     * @param consumer
     * @param <T>
     */
    private static <T> void dispose(boolean moreThread, int poolSize, List<T> taskLists, Consumer<T> consumer) throws InterruptedException {
        if(CollectionUtils.isEmpty(taskLists)){
            return;
        }

        if(moreThread && poolSize > 1){
            poolSize = Integer.min(poolSize, taskLists.size());
            ExecutorService executorService = null;
            try{
                executorService =  Executors.newFixedThreadPool(poolSize);
                CountDownLatch countDownLatch = new CountDownLatch(taskLists.size());
                for(T item : taskLists){
                    executorService.execute(()-> {
                        try{
                            consumer.accept(item);
                        }finally {
                            countDownLatch.countDown();
                        }
                    });
                }
                countDownLatch.await();
            }finally {
                if(executorService != null){
                    executorService.shutdown();
                }
            }
        }else{
            for(T item : taskLists){
                consumer.accept(item);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Stream.iterate(1, a->a+1).limit(10).collect(Collectors.toList());
        CountDownLatchTaskUtils.dispose(list, item->{
            try {
                long startTime = System.currentTimeMillis();
                TimeUnit.SECONDS.sleep(item);
                long endTime = System.currentTimeMillis();
                System.out.println(endTime + ", 任务：" + item + "执行完毕,耗时:" + (endTime-startTime) + " ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(list + "中的所有任务都执行完毕");
    }
}
