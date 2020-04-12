package com.iteller.kl.java.util.concurrent.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/10 17:56
 * description:
 */
public class MyAtomicReferenceFieldUpdater {

    volatile Boolean isInit = Boolean.FALSE;//notice not static

    static MyAtomicReferenceFieldUpdater myAtomicReferenceFieldUpdater = new MyAtomicReferenceFieldUpdater();

    AtomicReferenceFieldUpdater<MyAtomicReferenceFieldUpdater, Boolean> updater = AtomicReferenceFieldUpdater.newUpdater(MyAtomicReferenceFieldUpdater.class, Boolean.class, "isInit");

    public void init() throws InterruptedException {
        if(updater.compareAndSet(myAtomicReferenceFieldUpdater, Boolean.FALSE, Boolean.TRUE)){
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + "，开始初始化!");
            //模拟休眠3秒
            TimeUnit.SECONDS.sleep(3);
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + "，初始化完毕!");
        }else{
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + "，有其他线程已经执行了初始化!");
        }
    }

    public static void main(String[] args){
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    myAtomicReferenceFieldUpdater.init();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
