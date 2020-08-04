package com.kl.java.util.collection.list;

import java.util.ArrayList;

/**
 * author:18060903(iTeller_zc)
 * date:2019/10/24 14:41
 * description:
 */
public class MyArrayList {

    public static void main(String[] args){
        ArrayList<String> list = new ArrayList();
        list.add(new String());
        list.add("a");
        System.out.println(list);
        list.trimToSize();
        System.out.println(list);
        System.out.println(10>>1);
    }
}
