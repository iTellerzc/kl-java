package com.kl.java.lang.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 11:37
 * description:
 */
public class InterruptFlagExit {

    public static class T extends Thread{
        @Override
        public void run(){
            while(true){
                if(this.isInterrupted()){
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        TimeUnit.SECONDS.sleep(3);
        t.interrupt();
    }
}
