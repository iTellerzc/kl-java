package com.iteller.kl.math.al;

/**
 * author:18060903(iTeller_zc)
 * date:2020/1/21 9:48
 * description:取数组中的两数最大和,两数不相邻
 * 递归(正向 逆向) or 动态规划(正向 逆向)
 */
public class DynamicProgram {

    public static void main(String[] args){
        int[] nums = {8,1,0,12,9};
        int maxSum = dp(nums);
        System.out.println("max:" + maxSum);
    }

    private static int dp(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int current = 0;
        int step_1 = 0;
        int step_2 = 0;
        for(int i = 0; i<=nums.length-1; i++){
            System.out.println("i:" + i +", before current:" + current +", step1:" + step_1 + ", step2:" + step_2);
            current = Math.max(step_1, nums[i] + step_2);
            step_2 = step_1;
            step_1 = current;
            System.out.println("after current:" + current +", step1:" + step_1 + ", step2:" + step_2);
        }
        return current;
    }
}
