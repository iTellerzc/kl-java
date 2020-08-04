package com.kl.test.java;

import com.kl.test.pojo.ReWritePojo;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/25 9:23
 * description:
 */
public class JavaBasicTest {

    @Test
    public void testFloat(){
        float a = 0.125f;
        double b = 0.125d;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a-0.12f);
        System.out.println(b-0.12d);
        System.out.println(a-b);
        System.out.println(b-a);
        System.out.println((a-b)==0);
    }

    @Test
    public void testDouble(){
        double c = 0.8d;
        double d = 0.7d;
        double e = 0.6d;
        System.out.println(c-d);
        System.out.println(d-e);
        System.out.println(c-d == d-e);
    }

    @Test
    public void testZero(){
        System.out.println(1.0/0);
    }

    @Test
    public void testZero2(){
        System.out.println(0.0/0);
    }

    @Test
    public void testRewrite(){
        ReWritePojo reWritePojo = new ReWritePojo();
        //reWritePojo.a(null); compile error
        reWritePojo.b(1);
    }

    @Test
    public void testSwitch(){
        String a = null;
        switch (a){
            case "a":
                System.out.println("a");
                break;
            /*case null:
                System.out.println();*/
            default:
                System.out.println("default");
        }
    }
}
