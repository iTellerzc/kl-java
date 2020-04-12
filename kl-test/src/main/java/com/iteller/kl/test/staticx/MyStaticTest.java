package com.iteller.kl.test.staticx;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/1 17:31
 * description:
 */
public class MyStaticTest {

    static{
        System.out.println("main static");
    }

    public static void main(String[] args){
        //Inner inner = new Inner();
    }

    public static class Inner{
        static {
            System.out.println("child static");
        }
    }
}
