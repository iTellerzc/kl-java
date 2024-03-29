package com.kl.java.lang;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/3/20 16:19
 * description:
 */
public class MyClassLoader {

    public static void main(String[] args){
        ClassLoader classLoader = MyClassLoader.class.getClassLoader();
        System.out.println(classLoader.getClass().getName());
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent.getClass().getName());
       /* ClassLoader pp = parent.getParent();
        System.out.println(pp.getClass().getName());*/

       Integer[] arrays = {1};

       System.out.println(arrays.getClass().getClassLoader());
       for(Integer i : arrays){
           System.out.println(i.getClass().getClassLoader());
       }
       System.out.println(args.getClass().getClassLoader());
    }
}
