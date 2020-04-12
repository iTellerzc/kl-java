package com.iteller.kl.java.util.concurrent.locks.support;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 17:27
 * description:
                                                Object	                            Condtion	                 LockSupport
前置条件	                                    需要在synchronized中运行	       需要先获取Lock的锁	            无
无限等待	                                    支持	                            支持	                        支持
超时等待	                                    支持	                            支持	                        支持
等待到将来某个时间返回	                        不支持                             	支持	                        支持
等待状态中释放锁	                            会释放	                            会释放	                        不会释放
唤醒方法先于等待方法执行，能否唤醒线程	        否	                                否	                            可以
是否能响应线程中断	                            是	                                是	                            是
线程中断是否会清除中断标志	                    是	                                是	                            否
是否支持等待状态中不响应中断	                不支持                             	支持	                        不支持
 */
public class LockSupportWithObj {

    public static class BlockerObj{

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){

            @Override
            public void run(){
                LockSupport.park();
            }
        };
        thread.setName("t1");
        thread.start();

        final BlockerObj blockerObj = new BlockerObj();
        Thread t2 = new Thread(){

            @Override
            public void run(){
                LockSupport.park(blockerObj);
            }
        };
        t2.setName("t2");
        t2.start();

        TimeUnit.SECONDS.sleep(3);

        LockSupport.unpark(thread);
        LockSupport.unpark(t2);
    }
}
