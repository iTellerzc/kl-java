package com.iteller.kl.math.search;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/3/23 11:38
 * description:
 */
public class MyHalfFind {

    public static void main(String[] args){
        int[] arrays = {11};
        int target = 10;
        int index = halfFind(arrays, 0, arrays.length-1, target);
        System.out.println("target index: " + index);
    }

    private static int halfFind(int[] arrays, int start, int end, int target) {
        if(arrays == null || arrays.length == 0){
            return -1;
        }
        int middle = (start + end )/2;
        if(middle >=1){
            if(arrays[middle] == target){
                return middle;
            }else if(arrays[middle] > target){
                return halfFind(arrays, start, middle, target);
            }else{
                return halfFind(arrays, middle, end, target);
            }
        }else{
            return target == arrays[middle] ? 0 : -1;
        }

    }
}
