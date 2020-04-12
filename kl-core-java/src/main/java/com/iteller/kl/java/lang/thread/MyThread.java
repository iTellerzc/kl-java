package com.iteller.kl.java.lang.thread;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/2 16:10
 * description:
 */
public class MyThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("daemon...");
                /*try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println("daemon...");*/
            }
        });
        thread.setDaemon(true);

        thread.start();

        //TimeUnit.SECONDS.sleep(3);

        System.out.println("this is main class.");

    }
}
