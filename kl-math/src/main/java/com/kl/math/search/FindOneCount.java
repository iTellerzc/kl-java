package com.kl.math.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/28 19:27
 * description:
 * 找出数组中只出现一次的数字
 */
public class FindOneCount {

    public static void main(String[] args){
        int[] nums = {1,4,2,3,4,6,3,2};
        int[] result = singleNumber(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] singleNumber(int[] nums) {
        Set<Integer> resultSet = new HashSet<>();
        for(int value: nums){
            if(!resultSet.add(value)){
                resultSet.remove(value);
            }
        }
        int[] result = new int[resultSet.size()];
        Integer[] resultArray = resultSet.toArray(new Integer[0]);
        for(int i=0; i< result.length; i++){
            result[i] = resultArray[i];
        }
        return result;
    }
}
