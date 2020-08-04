package com.kl.java.util.concurrent.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 19:23
 * description:
 * 功能和HashMap基本一致，内部使用红黑树实现的。
 * 特性：
 * 迭代结果和存入顺序不一致
 * key和value都不能为空
 * 线程安全的
 */
public class MyConcurrentHashMap {
    static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(16);

    public static void main(String[] args){
        //putIfAbsent();
        concurrentTest();

    }

    private static void concurrentTest() {
        //CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i=0; i<10; i++){
            final int index = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " operate map.");
                map.putIfAbsent("key", "value" + index);
                //countDownLatch.countDown();
            }).start();
        }
        /*try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(map.get("key"));
    }

    private static void putIfAbsent() {
        String value = map.putIfAbsent("key", "value");
        System.out.println(value);
        value = map.putIfAbsent("key", "value1");
        System.out.println(value);
    }
}
