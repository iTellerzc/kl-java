package com.iteller.kl.java.util.concurrent.locks.deadlock.starvation;

import java.util.concurrent.Callable;

/**
 * @author iTeller_zc
 * date:2020/4/4
 * description:
 */
public class StarvationLock2 implements Callable<String> {


    @Override
    public String call() throws Exception {
        System.out.println("in starvation lock2 call.");
        return "another success";
    }
}





