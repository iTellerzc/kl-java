package com.kl.java.util.concurrent.collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 20:06
 * description:
 * CopyOnWriteArrayList是线程安全的List，内部使用数组存储数据，
 * 集合中多线程并行操作一般存在4种情况：读读、读写、写写、写读，
 * 这个只有在写写操作过程中会导致其他线程阻塞，其他3种情况均不会阻塞，所以读取的效率非常高。
 *
 * 迭代结果和存入顺序一致
 * 元素不重复
 * 元素可以为空
 * 线程安全的
 * 读读、读写、写读3种情况不会阻塞；写写会阻塞
 * 无界的
 */
public class MyCopyOnWriteArrayList {

    static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args){

    }
}
