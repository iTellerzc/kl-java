package com.iteller.kl.java.util.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 14:49
 * description:
 */
public class LoopCyclicBarrierTest {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    public static class T extends Thread{

        int sleep;

        public T(String name, int sleep){
            super(name);
            this.sleep = sleep;
        }

        public void eat(){
            try {
                TimeUnit.SECONDS.sleep(sleep);
                long startTime = System.currentTimeMillis();
                cyclicBarrier.await();
                long endTime = System.currentTimeMillis();
                System.out.println(getName() + " sleep:" + sleep + "s, wait :" + (endTime - startTime) + "ms to eat, enjoy.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public void drive(){
            try {
                TimeUnit.SECONDS.sleep(sleep);
                long startTime = System.currentTimeMillis();
                cyclicBarrier.await();
                long endTime = System.currentTimeMillis();
                System.out.println(getName() + " sleep:" + sleep +"s, wait :" + (endTime - startTime) + "ms to drive.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run(){
            drive();
            eat();
        }
    }

    public static void main(String[] args){
        //must equal cyclic parties
        for(int i=1; i<=10; i++){
            new T("obj" + i, i).start();
        }
    }
}
