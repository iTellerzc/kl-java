package com.kl.java.lang.thread;
import java.util.concurrent.TimeUnit;

/**
 * @author iTeller_zc
 * date:2020/4/5
 * description:
 */
public class JoinYeildTest {

    static int num = 0;

    public static class T1 extends Thread{
        public T1(String name){
            super(name);
        }

        @Override
        public void run(){

            System.out.println(System.currentTimeMillis() + " , start " + getName());
            for(int i=0; i<10; i++){
                num ++;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(System.currentTimeMillis() + ", end " + getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1("t1");
        t1.start();

        t1.join();
        System.out.println(System.currentTimeMillis() + ", num=" + num);

    }
}
