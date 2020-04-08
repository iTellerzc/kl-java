package com.iteller.kl.java.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/8 19:08
 * description:
 */
public class MyUnsafe {

    private static Unsafe unsafe;

    static{
        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        System.out.println(unsafe);
    }
}
