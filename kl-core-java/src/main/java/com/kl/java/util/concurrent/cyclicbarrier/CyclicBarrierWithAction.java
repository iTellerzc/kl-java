package com.kl.java.util.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 14:49
 * description:
 */
public class CyclicBarrierWithAction {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "让大家久等了，给大家倒酒！");
        }
    });

    public static class T extends Thread{

        int sleep;

        public T(String name, int sleep){
            super(name);
            this.sleep = sleep;
        }

        @Override
        public void run(){
            try {
                TimeUnit.SECONDS.sleep(sleep);
                long startTime = System.currentTimeMillis();
                cyclicBarrier.await();
                long endTime = System.currentTimeMillis();
                System.out.println(getName() + " sleep:" + sleep + " s, wait :" + (endTime - startTime) + "ms, enjoy.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        //must equal cyclic parties
        for(int i=1; i<=10; i++){
            new T("obj" + i, i).start();
        }
    }
}
