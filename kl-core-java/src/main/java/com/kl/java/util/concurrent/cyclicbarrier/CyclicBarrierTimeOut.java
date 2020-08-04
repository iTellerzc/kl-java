package com.kl.java.util.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 14:49
 * description:
 * 等待超时的方法
    *public int await(long timeout, TimeUnit unit) throws InterruptedException,BrokenBarrierException,TimeoutException
    *内部有一个人把规则破坏了（等待超时），其他人都不按规则来了，不会等待了
 * 等待超时的线程，await方法会触发TimeoutException异常，然后被唤醒向下运行
 * 其他等待中或者后面到达的线程，会在await()方法上触发`BrokenBarrierException`异常，然后继续执行
 */
public class CyclicBarrierTimeOut {

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
                if(getName().equals("obj1")){
                    cyclicBarrier.await(5, TimeUnit.SECONDS);
                    //cyclicBarrier.await();
                }else{
                    //阻塞
                    cyclicBarrier.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            endTime = System.currentTimeMillis();
            System.out.println(getName() + " sleep:" + sleep + " s, wait:" +( endTime - startTime) +" ms");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //must equal cyclic parties
        for(int i=1; i<=10; i++){
            new T("obj"+i, i).start();

        }
    }
}
