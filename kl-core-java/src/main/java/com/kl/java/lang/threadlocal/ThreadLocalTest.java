package com.kl.java.lang.threadlocal;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/3/26 20:21
 * description:
 */
public class ThreadLocalTest {

    public static void main(String[] args){
        MyThreadLocalHolder.setUser("iTeller_zc");
        String userId = MyThreadLocalHolder.getUser();
        MyThreadLocalHolder.setUser("iTeller");
        System.out.println(userId);
        System.out.println(MyThreadLocalHolder.getUser());
    }
}
