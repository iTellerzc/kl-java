package com.kl.java.lang.thread.safe;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 11:20
 * description:
 */
public class SynchronizedTest {

    //作用于实例对象
    public synchronized void m1(){

    }

    public synchronized void m2(){

    }

    public void m3(){
        synchronized (this){

        }
    }


    //作用于class
    public static synchronized void m4(){

    }

    public static void m5(){
        synchronized (SynchronizedTest.class){

        }
    }

    public static class T extends Thread{
        private SynchronizedTest synchronizedTest;

        public T(SynchronizedTest synchronizedTest){
            this.synchronizedTest = synchronizedTest;
        }

        @Override
        public void run(){
            super.run();
        }
    }

    public static void main(String[] args){
        final SynchronizedTest synchronizedTest = new SynchronizedTest();
        Thread t1 = new Thread(){

            @Override
            public void run(){
                synchronizedTest.m1();
            }
        };
        t1.start();

        Thread t2 = new Thread(){

            @Override
            public void run(){
                synchronizedTest.m2();
            }
        };
        t2.start();

        Thread t3 = new Thread(){

            @Override
            public void run(){
                synchronizedTest.m3();
            }
        };
        t3.start();

        final SynchronizedTest test = new SynchronizedTest();
        Thread t4 = new Thread(){

            @Override
            public void run(){
                test.m2();
            }
        };
        t4.start();
        Thread t5 = new Thread(){

            @Override
            public void run(){
                SynchronizedTest.m4();
            }
        };
        t5.start();
        Thread t6 = new Thread(){

            @Override
            public void run(){
                SynchronizedTest.m5();
            }
        };
        t6.start();
    }
}
