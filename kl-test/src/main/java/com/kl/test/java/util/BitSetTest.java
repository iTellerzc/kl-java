package com.kl.test.java.util;

import org.testng.annotations.Test;

import java.util.BitSet;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/17 10:19
 * description:
 */
public class BitSetTest {

    @Test
    public void testSet(){
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        System.out.println(bitSet.get(1));
    }


    @Test
    public void testClear(){
        BitSet bitSet = new BitSet();
        bitSet.clear();
    }

    @Test
    public void testSize(){
        BitSet bitSet = new BitSet();
        System.out.println(bitSet.size());
        for(int i=0; i< bitSet.size(); i++){
            System.out.println(bitSet.get(i));
        }
    }

    @Test
    public void testNextSetBit(){
        BitSet bitSet = new BitSet();
        bitSet.set(2);//set true
        System.out.println(bitSet.nextSetBit(0));
    }

    @Test
    public void testNextClearBit(){
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        System.out.println(bitSet.nextClearBit(1));
    }
}
