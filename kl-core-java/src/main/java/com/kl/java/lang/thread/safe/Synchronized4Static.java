package com.kl.java.lang.thread.safe;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 11:01
 * description:
 */
public class Synchronized4Static {

    static int num = 0;

    public static synchronized void add(){
        num++;
    }

    public static void addInner(){
        synchronized (Synchronized4Static.class){
            for(int i=0 ; i<10000; i++){
                num++;
            }
        }
    }

    public static class T extends Thread {

        @Override
        public void run() {
            /*for (int i = 0; i < 10000; i++) {
                Synchronized4Static.add();
            }*/
            Synchronized4Static.addInner();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        T t2 = new T();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(num);
    }
}
