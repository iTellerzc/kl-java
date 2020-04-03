package com.iteller.kl.math.merge;

import org.apache.commons.compress.utils.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/3 15:31
 * description:合并两个有序数组
 */
public class MergeSortList {

    public List<Integer> mergeList(List<Integer> l1, List<Integer> l2){
        List<Integer> result = Lists.newArrayList();
        int l1_index = 0;
        int l2_index = 0;
        while(l1_index < l1.size() && l2_index < l2.size()){
            if(l1.get(l1_index) < l2.get(l2_index)){
                result.add(l1.get(l1_index));
                l1_index ++;
            }else {
                result.add(l2.get(l2_index));
                l2_index ++;
            }
        }
        while(l1_index < l1.size()){
            result.add(l1.get(l1_index));
            l1_index ++;
        }
        while (l2_index < l2.size()){
            result.add(l2.get(l2_index));
            l2_index ++;
        }
        return result;
    }

    public static void main(String[] args){
        List<Integer> l1 = Arrays.asList(new Integer[]{1,3,6,12});
        List<Integer> l2 = Arrays.asList(new Integer[]{0,2,3,5,13});
        MergeSortList mergeSortList = new MergeSortList();
        List<Integer> result = mergeSortList.mergeList(l1, l2);
        for(Integer i : result){
            System.out.println(i);
        }
    }
}
