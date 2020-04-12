package com.iteller.kl.test.pojo;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * author:18060903(iTeller_zc)
 * date:2019/11/4 19:05
 * description:
 */
public class ItTask implements Runnable {

    private CopyOnWriteArrayList<Pojo> list;

    public ItTask(CopyOnWriteArrayList<Pojo> list){
        this.list = list;
    }

    public void run() {
        for(Pojo pojo : list){
            System.out.println(pojo.getAge());
        }
    }
}
