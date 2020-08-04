package com.kl.java.util.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 14:49
 * description:
 * 内部有一个人把规则破坏了（接收到中断信号），其他人都不按规则来了，不会等待了
 * 接收到中断信号的线程，await方法会触发InterruptedException异常，然后被唤醒向下运行
 * 其他等待中 或者后面到达的线程，会在await()方法上触发`BrokenBarrierException`异常，然后继续执行
 */
public class CyclicBarrierInterrupt {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    public static class T extends Thread{

        int sleep;

        public T(String name, int sleep){
            super(name);
            this.sleep = sleep;
        }

        @Override
        public void run(){
            long startTime = 0;
            long endTime = 0;
            try {
                TimeUnit.SECONDS.sleep(sleep);
                startTime = System.currentTimeMillis();
                System.out.println(getName() + " 到了");
                //阻塞
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            endTime = System.currentTimeMillis();
            System.out.println(getName() + " sleep:" + sleep + " s, wait:" +( endTime - startTime) +" ms");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //must equal cyclic parties
        for(int i=1; i<=10; i++){
            int sleep = 0;
            if(i == 10){
                sleep =10;
            }
            T t = new T("obj" + i, sleep);
            t.start();

            if(i == 5){
                TimeUnit.SECONDS.sleep(1);
                System.out.println(t.getName() + " 有点急事，先开干！");
                t.interrupt();
                TimeUnit.SECONDS.sleep(2);
            }

        }
    }
}
