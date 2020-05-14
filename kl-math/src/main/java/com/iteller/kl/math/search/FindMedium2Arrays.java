package com.iteller.kl.math.search;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/14 11:33
 * description:两个有序数组n1,n2的中位数,n1 n2不同时为空,时间复杂度 O(log(n1.length+n2.length))
 * 在统计中，中位数被用来：
 * 将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素。
 */
public class FindMedium2Arrays {

    public static void main(String[] args){
        int[] nums1 = {1, 3, 5, 6};
        int[] nums2 = {2, 4, 7, 8};
        double medianNum = findMedianSortArrays(nums1, nums2);
        System.out.println(medianNum);
    }

    private static double findMedianSortArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if(length1 == 0){
            return singleSearch(nums2);
        }else if(length2 == 0){
            return singleSearch(nums1);
        }else{
            //merge
            int[] mergeResult = mergeAndSort(nums1, nums2);
            //search
            return singleSearch(mergeResult);
        }
    }

    private static int[] mergeAndSort(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int index = 0;
        int[] mergeResult = new int[nums1Length + nums2Length];

        while(index1 < nums1Length && index2 < nums2Length){
              if(nums1[index1] < nums2[index2]){
                  mergeResult[index] = nums1[index1++];
              }else{
                  mergeResult[index] = nums2[index2++];
              }
              index++;
        }

        while(index1 < nums1Length){
            mergeResult[index++] = nums1[index1++];
        }
        while(index2 < nums2Length){
            mergeResult[index++] = nums2[index2++];
        }

        return mergeResult;
    }

    private static double singleSearch(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int length = nums.length;
        int half = length /2;
        if(length % 2 == 0){
            return (nums[half-1] + nums[half]) / 2.0;
        }else{
            return nums[half];
        }
    }
}
