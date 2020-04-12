package com.iteller.kl.test;

import com.iteller.kl.test.pojo.Pojo;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * author:18060903(iTeller_zc)
 * date:2019/11/4 19:05
 * description:
 */
public class AddTask implements Runnable {

    private CopyOnWriteArrayList<Pojo> list;

    public AddTask(CopyOnWriteArrayList<Pojo> list){
        this.list = list;
    }
    public void run() {
        for(int i = 0; i < 100; i++){
            Pojo pojo = new Pojo(i);
            System.out.println(list.add(pojo));
        }
    }
}
