package com.kl.java.util.concurrent.executors.thread;

import java.util.Random;

/**
 * author:18060903(iTeller_zc)
 * date:2019/12/5 9:50
 * description:
 */
public class MyRunnable implements Runnable {

    private Long addTime;

    private int seq;

    public MyRunnable(Long addTime, int i){
        this.addTime = addTime;
        this.seq = i;
    }

    public void run() {
        long sleep = new Random().nextInt(10)* 300L;
        String threadName = Thread.currentThread().getName();
        Long now = System.currentTimeMillis();
        System.out.println("seq:" + seq
                + "," + threadName
                + ",add at:" + addTime
                        + ",execute at:" + now
                        + ",sleep:" + sleep
                        + ",delay:" + (now - addTime));
        try {
            Thread.sleep(sleep);
            System.out.println("seq:" + seq + "," + threadName + " execute finish!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
