package com.kl.java.lang.thread.daemon;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 10:39
 * description:
 */
public class DaemonThreadTest {

    public static class DaemonThread extends Thread{

        public DaemonThread(String name){
            super(name);
        }

        @Override
        public void run(){
            System.out.println("thread name:" + getName() + "开始执行," + (isDaemon() ? "守护线程" :"用户线程"));
            while(true);
        }
    }

    public static void main(String[] args){
        DaemonThread dt = new DaemonThread("子线程");
        dt.setDaemon(true);
        //before start set daemon!!!
        dt.start();
        //dt.setDaemon(true);
        System.out.println("主线程结束");
    }
}
