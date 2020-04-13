package com.iteller.kl.java.util.concurrent.collection;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/13 19:30
 * description:
 * 内部使用跳表实现的，放入的元素会进行排序，排序算法支持2种方式来指定：
 * 通过构造方法传入一个Comparator
 * 放入的元素实现Comparable接口
 * 上面2种方式必选一个，如果2种都有，走规则1。
 * 特性：
 * 迭代结果和存入顺序不一致
 * 放入的元素会排序
 * key和value都不能为空
 * 线程安全的
 */
public class MyConcurrentSkipListMap {

    static ConcurrentSkipListMap<String, Integer> concurrentSkipListMap = new ConcurrentSkipListMap(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int diff = o1.compareTo(o2);
            System.out.println(o1 + ", " + o2 +" differ:" + diff);
            return diff;
        }
    });

    public static void main(String[] args){
        for(int i=10; i > 0; i--){
            concurrentSkipListMap.put("key" + i, i);
            //System.out.println("size:" + concurrentSkipListMap.size());
        }

       for(Map.Entry<String, Integer> entry : concurrentSkipListMap.entrySet()){
            System.out.println("key:" + entry.getKey());
            System.out.println("value:" + entry.getValue());
       }
    }
}
