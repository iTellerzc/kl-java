package com.iteller.kl.java.util.concurrent.executors.schedule;

/**
 * @author:18060903(iTeller_zc)
 *
 * date:2020/3/6 17:38
 * description:
 */
public class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name){
        this.name = name;
    }
    public void run() {
        System.out.println(name + " run at " + System.currentTimeMillis());
    }
}
