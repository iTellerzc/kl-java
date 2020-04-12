package com.iteller.kl.java.lang.thread.safe;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 10:54
 * description:
 */
public class NotThreadSafe {

    static int num = 0;

    public static void add(){
        for(int i=0; i<10000; i++){
            num++;
        }
    }
    public static class T extends Thread{

        @Override
        public void run(){
            add();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(num);
    }
}
