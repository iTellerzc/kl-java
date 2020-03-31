package com.iteller.kl.java.util;


import java.util.concurrent.ArrayBlockingQueue;

/**
 * author:18060903(iTeller_zc)
 * date:2019/10/29 11:01
 * description:
 */
public class MyQueue {

    public static void main(String[] args){
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(2, false);
        queue.add("a");
        queue.offer("b");
        queue.offer("c");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.element());
    }
}
