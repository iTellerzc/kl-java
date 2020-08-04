package com.kl.test.java.lang;

import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/2 19:26
 * description:
 */
public class ShortTest {

    @Test
    public void testConvert2Bytes(){
        short i = 10;
        short result = Short.reverseBytes(i);
        System.out.println(result);
    }
}
