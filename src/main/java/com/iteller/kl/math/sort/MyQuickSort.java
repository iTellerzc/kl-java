package com.iteller.kl.math.sort;


import java.util.Arrays;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/3/23 11:37
 * description:
 * 1.找基准索引(数组基准索引左边元素小于该基准索引元素，基准索引右边元素大于该基准索引元素)
 * 2.左排序(递归)
 * 3.右排序(递归)
 */
public class MyQuickSort {

    public static void main(String[] args){
        int[] inputArrays = {3,8,13,2,5,7,9};
        System.out.println("original arrays :" + Arrays.toString(inputArrays));
        quickSort(inputArrays, 0, inputArrays.length-1);
    }

    private static void quickSort(int[] inputArrays, int start, int end) {
        if(start < end){
            int baseIndex = getBaseIndex(inputArrays, start, end);
            quickSort(inputArrays, start, baseIndex-1);
            quickSort(inputArrays, baseIndex+1, end);
        }
    }

    private static int getBaseIndex(int[] inputArrays, int head, int tail) {
        //临时基准数据
        int temp = inputArrays[head];
        System.out.println("before arrays:" + Arrays.toString(inputArrays) + ", head:" + head + ", tail:" + tail + ",temp:" + temp);
        while(head < tail){
            //队尾元素小于等于基准数据，队尾向前移动
            while(head < tail &&  temp <= inputArrays[tail]){
                tail --;
            }
            //System.out.println("get smallest from right head index:" + head +", tail index:" + tail);
            //如果队尾数据小于基准数据，队尾元素赋值给队首
            inputArrays[head] = inputArrays[tail];
            //队首元素小于等于基准数据，队首向后移动
            while (head < tail && temp >= inputArrays[head]){
                head ++;
            }
            //System.out.println("get smallest from left, head index:" + head +", tail index:" + tail);
            //如果队首数据大于基准数据，队首数据赋值给队尾
            inputArrays[tail] = inputArrays[head];
        }
        //重新赋值给队首基准数据，队尾队首位置重叠
        inputArrays[head] = temp;
        System.out.println("after arrays:" + Arrays.toString(inputArrays) + ", head:" + head + ", tail:" + tail + ", temp:" + temp);
        return head;//返回队首位置索引
    }
}
