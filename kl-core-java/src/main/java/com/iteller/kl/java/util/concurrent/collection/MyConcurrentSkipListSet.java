package com.iteller.kl.java.util.concurrent.collection;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 20:10
 * description:
 *
 * 有序的Set，内部基于ConcurrentSkipListMap实现的，放入的元素会进行排序，排序算法支持2种方式来指定：
 * 通过构造方法传入一个Comparator
 * 放入的元素实现Comparable接口
 * 上面2种方式需要实现一个，如果2种都有，走规则1
 * 特性：
 * 迭代结果和存入顺序不一致
 * 放入的元素会排序
 * 元素不重复
 * 元素不能为空
 * 线程安全的
 * 无界的
 */
public class MyConcurrentSkipListSet {
}
