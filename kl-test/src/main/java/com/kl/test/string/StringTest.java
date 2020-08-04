package com.kl.test.string;

import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/17 19:25
 * description:
 */
public class StringTest {

    @Test
    public void testIntern(){
        System.out.println("case1");
        String a = new String("hello");
        System.out.println(a.equals(a.intern()));
        System.out.println(a.equals("hello"));
        System.out.println(a == a.intern());

        // case2
        System.out.println("case2");
        String origin2 = new StringBuilder().append("aaa").append("bbb").toString();
        System.out.println(origin2);
        String s1 = "aaabbb";
        System.out.println(origin2.intern() == origin2);    // false
        System.out.println(origin2 == origin2.intern());    // false
        System.out.println(s1.intern() == origin2.intern());    // true

        // case3
        System.out.println("case3");
        String origin3 = new StringBuilder().append("ccc").append("ddd").toString();
        System.out.println(origin3.intern() == origin3);    // true
    }
}
