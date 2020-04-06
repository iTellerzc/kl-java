package com.iteller.kl.java.lang.thread.safe;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/6 11:01
 * description:
 */
public class Synchronized4Obj {

    int num = 0;

    public synchronized void add(){
        num++;
    }

    public static class T extends Thread{
        private Synchronized4Obj synchronized4Obj;

        public T(Synchronized4Obj synchronized4Obj){
            this.synchronized4Obj = synchronized4Obj;
        }

        @Override
        public void run(){
            for(int i=0; i<10000; i++){
                this.synchronized4Obj.add();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Synchronized4Obj synchronized4Obj = new Synchronized4Obj();
        T t1 = new T(synchronized4Obj);
        T t2 = new T(synchronized4Obj);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(synchronized4Obj.num);
    }
}
