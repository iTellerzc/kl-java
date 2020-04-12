package com.iteller.kl.java.util.concurrent.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/9 19:29
 * description:
 */
public class MyAtomicStampedReference {

    private static int accountMoney = 19;

    private static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(accountMoney, 0);

    public static void main(String[] args) throws InterruptedException {
        recharge();
        consume();
    }

    private static void consume() throws InterruptedException {
        for(int i=0; i<50; i++){
            int balance = money.getReference();
            int stamp = money.getStamp();
            if(balance > 20){
                if(money.compareAndSet(balance, balance - 20, stamp, stamp+1)){
                    System.out.println("当前时间戳:" + money.getStamp() +",当前余额:" + balance + ", 大于20元， 消费20元， 余额:" + money.getReference() + "元");
                }
            }
            TimeUnit.MICROSECONDS.sleep(50);
        }
    }

    private static void recharge() {
        for(int i=0; i<2; i++){
            int stamp = money.getStamp();
            new Thread(() -> {
                for(int j=0; j<5; j++){
                    int balance = money.getReference();
                    if(balance == accountMoney){
                        if(money.compareAndSet(balance, balance + 20, stamp, stamp + 1)){
                            System.out.println("当前时间戳:" + money.getStamp() + ", 当前余额:" + balance + ", 小于20元， 充值20元， 余额:" + money.getReference() + "元");
                        }
                    }
                    try {
                        TimeUnit.MICROSECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
