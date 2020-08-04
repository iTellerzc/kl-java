package com.kl.java.lang.thread.safe;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 11:01
 * description:
 */
public class Synchronized4Block implements Runnable{

    static Synchronized4Block synchronized4Block = new Synchronized4Block();

    static int i=0;

    public void run() {
        //other function...

        /*synchronized (synchronized4Block){
            for(int loop=0; loop<10000; loop++){
                System.out.println(Thread.currentThread().getName() + ",get lock.");
                i++;
            }
        }*/

       /* synchronized (this){
            for(int loop=0; loop<10000; loop++){
                //System.out.println(Thread.currentThread().getName() + ",get lock.");
                i++;
            }
        }*/

        synchronized (Synchronized4Block.class){
            for(int loop=0; loop<10000; loop++){
                //System.out.println(Thread.currentThread().getName() + ",get lock.");
                i++;
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(synchronized4Block);
        Thread t2 = new Thread(synchronized4Block);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);

    }
}
