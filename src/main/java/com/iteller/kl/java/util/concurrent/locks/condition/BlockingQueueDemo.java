package com.iteller.kl.java.util.concurrent.locks.condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 15:51
 * description:
 *
 * Object的监视器方法与Condition接口的对比
 * 局限性
 * 两种方式中的让线程等待和唤醒的方法能够执行的先决条件是：线程需要先获取锁
 * 唤醒方法需要在等待方法之后调用，线程才能够被唤醒
    对比项	                                        Object 监视器方法	                    Condition
    前置条件	                                       获取对象的锁	            调用Lock.lock获取锁，调用Lock.newCondition()获取Condition对象
    调用方式	                                       直接调用，如：object.wait()	        直接调用，如：condition.await()
    等待队列个数	                                   一个	                            多个，使用多个condition实现
    当前线程释放锁并进入等待状态	                    支持	                                    支持
    当前线程释放锁进入等待状态中不响应中断	            不支持	                                    支持
    当前线程释放锁并进入超时等待状态	                支持	                                    支持
    当前线程释放锁并进入等待状态到将来某个时间	        不支持	                                    支持
    唤醒等待队列中的一个线程	                        支持	                                    支持
    唤醒等待队列中的全部线程	                        支持	                                    支持
 */
public class BlockingQueueDemo<E> {
    private int size = 0;//队列大小

    private static ReentrantLock lock = new ReentrantLock(false);

    private static Condition notFullCondition = lock.newCondition();
    private static Condition notEmptyCondition = lock.newCondition();

    private LinkedList<E> list = new LinkedList<E>();

    public BlockingQueueDemo(int size){
        this.size = size;
    }

    public void enqueue(E e) throws InterruptedException {
        lock.lock();
        try{
            while(list.size() == size){
                //队列已满 通知生产者阻塞
                notFullCondition.await();
            }
            System.out.println("入队:" + e);
            list.add(e);
            //通知消费者消费
            notEmptyCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    public E dequeue() throws InterruptedException {
        E e;
        lock.lock();
        try {
            while(list.size() == 0){
                //队列为空,消费者等待
                notEmptyCondition.await();
            }
            e = list.removeFirst();//移除链表首个元素
            System.out.println("出队:" + e);
            //通知生产者
            notFullCondition.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final BlockingQueueDemo<Integer> queue = new BlockingQueueDemo<Integer>(2);

        //入队线程
        for(int i=0; i< 10; i++){
            final int data = i;
            new Thread(new Runnable() {

                public void run() {
                    try {
                        queue.enqueue(data);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
            }).start();
        }

        //出队线程
        for(int i=0; i<10; i++){
            new Thread(new Runnable() {

                public void run() {
                    try {
                        Integer data = queue.dequeue();
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
            }).start();
        }

        //TimeUnit.SECONDS.sleep(10);
    }

}
