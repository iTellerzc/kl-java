package com.kl.java.util.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/7 14:49
 * description:
 * 还是举例子说明一下：
    CountDownLatch示例
    主管相当于 CountDownLatch，干活的小弟相当于做事情的线程。
    老板交给主管了一个任务，让主管搞完之后立即上报给老板。主管下面有10个小弟，接到任务之后将任务划分为10个小任务分给每个小弟去干，主管一直处于等待状态（主管会调用await()方法，此方法会阻塞当前线程），让每个小弟干完之后通知一下主管（调用countDown()方法通知主管，此方法会立即返回），主管等到所有的小弟都做完了，会被唤醒，从await()方法上苏醒，然后将结果反馈给老板。期间主管会等待，会等待所有小弟将结果汇报给自己。
    而CyclicBarrier是一批线程让自己等待，等待所有的线程都准备好了，自己才能继续。
 */
public class CyclicBarrierTimeOutReset {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    static boolean reset = false;

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
                if(!reset){
                    if(getName().equals("obj1")){
                        cyclicBarrier.await(5, TimeUnit.SECONDS);
                        //cyclicBarrier.await();
                    }else{
                        //阻塞
                        cyclicBarrier.await();
                    }
                }else{
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

        TimeUnit.SECONDS.sleep(15);


        System.out.println("有序进行-----------");
        cyclicBarrier.reset();
        reset = true;
        for(int i=1; i<=10; i++){
            new T("obj"+i, i).start();
        }
    }
}
