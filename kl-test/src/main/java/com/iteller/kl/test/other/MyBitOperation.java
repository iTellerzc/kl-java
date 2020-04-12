package com.iteller.kl.test.other;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/3/27 9:53
 * description:
 */
public class MyBitOperation {
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args){
        System.out.println(MAXIMUM_CAPACITY);
        int c = 4;
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        c = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println(c);
    }
}
