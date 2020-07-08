package com.iteller.kl.test.java.lang;

import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/6 9:18
 * description:
 */
public class ByteTest {

    @Test
    public void testValueOf(){
        System.out.println(Byte.valueOf("47"));
    }

    @Test
    public void testDecode(){
        System.out.println(Byte.decode("0x10"));
    }

    @Test
    public void test2UnsignedInt(){
        System.out.println(Byte.toUnsignedInt((byte)(32)));
    }
}
