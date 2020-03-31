package com.iteller.kl.foo;

import com.iteller.kl.foo.pojo.ItTask;
import com.iteller.kl.foo.pojo.Pojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * author:18060903(iTeller_zc)
 * date:2019/10/21 17:39
 * description:
 */
public class Foo {

    private static final Logger LOGGER = LoggerFactory.getLogger(Foo.class);

    public static void main(String[] args){
        //LOGGER.info("this is foo main class.");
        CopyOnWriteArrayList<Pojo> list = new CopyOnWriteArrayList<Pojo>();
        Thread thread = new Thread(new AddTask(list));
        Thread thread2 = new Thread(new ItTask(list));
        for(int i=0; i<=100; i++){
            thread.start();
            thread2.start();
        }
        /*for(int i=0; i<100; i++){
            Pojo pojo = new Pojo(i);
            list.add(pojo);
            if(i % 2 ==0){
                pojo.setAge(i * 100);
            }
            System.out.println("age:" + list.get(i).getAge());
        }*/
        System.out.println("size:" + list.size());
    }
}
