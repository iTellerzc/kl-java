package com.iteller.kl.java.util.concurrent.collection;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 20:12
 * description:
 * 内部使用CopyOnWriteArrayList实现的，将所有的操作都会转发给CopyOnWriteArrayList。
 * 特性：
 * 迭代结果和存入顺序不一致
 * 元素不重复
 * 元素可以为空
 * 线程安全的
 * 读读、读写、写读 不会阻塞；写写会阻塞
 * 无界的
 */
public class CopyOnWriteArraySet {
}
