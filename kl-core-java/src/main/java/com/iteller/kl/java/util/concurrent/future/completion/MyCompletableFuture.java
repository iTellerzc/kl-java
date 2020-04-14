package com.iteller.kl.java.util.concurrent.future.completion;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class MyCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //no return
        //runAsync();

        //have return
        //long time = supplyAsync();
        //System.out.println("time:" + time);

        //callback
        //whenComplete();

        //thenApply no exception
        //thenApply();

        //can catch exception
        // handle();

        //thenAccept wait result
        //thenAccept();

        //thenRun no result
        //thenRun();

        //then combine
        //thenCombine();

        //then acceptBoth
        thenAcceptBoth();
    }

    private static void thenAcceptBoth() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {

                int result = new Random().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f1:" + result);
                return result;
            }
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {

                int result = new Random().nextInt(5);
                try {
                    TimeUnit.SECONDS.sleep(result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("f2:" + result);
                return result;
            }
        });

        future1.thenAcceptBoth(future2, new BiConsumer<Integer, Integer>() {

            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println("f1:" + integer + ",f2:" + integer2);
            }
        });

        future1.get();

        future2.get();
    }

    private static void thenCombine() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return ", world！";
            }
        });

        CompletableFuture<String> result = future1.thenCombine(future2, new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s + s2;
            }
        });

        System.out.println(result.get());
    }

    private static void thenRun() throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    return new Random().nextInt(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return -1;
            }
        }).thenAccept(integer -> {
            System.out.println("thenRun....");
            //return integer;
        });

        System.out.println("result:" + future.get());
    }


    private static void thenAccept() throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        }).thenAccept(integer -> {
            System.out.println(integer);
        });

        future.get();
    }

    private static void handle() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                //int i=10/0;
                return new Random().nextInt(10);
            }
        }).handle(new BiFunction<Integer, Throwable, Integer>() {
            @Override
            public Integer apply(Integer integer, Throwable throwable) {
                int result = -1;
                if(throwable!=null){
                    System.out.println(throwable.getMessage());
                }else {
                    result = integer * 2;
                }
                return result;
            }
        });

        System.out.println("result:" + future.get());
    }


    /**
     * Function
     * T：上一个任务返回结果的类型
     * U：当前任务的返回值类型
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void thenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(new Supplier<Long>() {
            @Override
            public Long get() {
                long result = new Random().nextInt(100);
                System.out.println("result1:" + result);
                result = result/0;
                return result;
            }
        }).thenApply(new Function<Long, Long>() {

            @Override
            public Long apply(Long aLong) {
                long result = aLong * 5;

                System.out.println("result2:" + result);
                return result;
            }
        });

        long result = future.get();
        System.out.println(result);
    }

    /**
     * whenComplete 和 whenCompleteAsync 的区别：
       whenComplete：是执行当前任务的线程执行继续执行 whenComplete 的任务。
       whenCompleteAsync：是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行
     *
     */
    private static void whenComplete() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(
                () ->{
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("run end...");
                    throw new RuntimeException("runtime exception.");

                }

        );

        future.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void aVoid, Throwable throwable) {
                System.out.println("执行完成。。。");
            }
        });

        future.exceptionally(new Function<Throwable, Void>() {

            @Override
            public Void apply(Throwable throwable) {
                System.out.println("执行失败：" + throwable.getMessage());
                return null;
            }
        });

        try {

            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static long supplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(
                () ->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("run end and return...");
                    return System.currentTimeMillis();
                }

        );


        //blocking
        long time = future.get();
        return time;
    }


    private static void runAsync() throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future = CompletableFuture.runAsync(
                () ->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("run end...");
                }

        );


        //blocking
        future.get();
    }
}
