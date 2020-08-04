package com.kl.math.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/21 19:43
 * description:
 * 给定数组元素和目标值,找出数据中两个数和为目标值的下标
 * eg:args:[2,7,9,11] tagrget:9
 * return [0,1] 2+7=9
 * 暴力解决 o(n^2)
 * hash解决  simple o(n)
 */
public class TwoNumberSum {

    public static void main(String[] args){
        int[] nums = {3,3};
        int target = 6;
        //int[] result = my2Sum(nums, target);
        int[] result = hashSearch(nums, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] hashSearch(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("not found.");
    }

    private static int[] my2Sum(int[] nums, int target) {
        int resetIndex = -1;
        int firstIndex = 0;
        for(int loop=0; loop<nums.length; loop ++){
            firstIndex = loop;
            int reset = target - nums[firstIndex];
            resetIndex = find(reset, firstIndex, nums);
            if(resetIndex>0){
                break;
            }
        }
        int[] result = {firstIndex, resetIndex};
        return result;
    }

    private static int find(int target, int startIndex, int[] nums) {
        for(int i=startIndex+1; i<nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
