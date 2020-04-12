package com.iteller.kl.java.lang.threadlocal;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/3/26 20:14
 * description:
 */
public class MyThreadLocalHolder {

    public static final ThreadLocal<String> USER_ID = new ThreadLocal<String>();

    public static void setUser(String user){
        USER_ID.set(user);
    }

    public static String getUser(){
        String userId = USER_ID.get();
        if(userId == null){
            userId = "empty";
            USER_ID.set(userId);
        }
        return userId;
    }
}
