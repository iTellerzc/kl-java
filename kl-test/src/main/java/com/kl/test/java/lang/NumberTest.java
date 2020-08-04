package com.kl.test.java.lang;

import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/3 9:43
 * description:
 */
public class NumberTest {

    @Test
    public void testGetIntValue(){
        Number number = new Integer(10);
        System.out.println(number.intValue());
    }
}
