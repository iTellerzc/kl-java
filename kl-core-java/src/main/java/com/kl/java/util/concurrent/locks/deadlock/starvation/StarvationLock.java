package com.kl.java.util.concurrent.locks.deadlock.starvation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author iTeller_zc
 * date:2020/4/4
 * description:
 */
public class StarvationLock implements Callable<String> {

    private ExecutorService executorService;

    public StarvationLock(ExecutorService executorService){
        this.executorService = executorService;
        //this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public String call() throws Exception {
        System.out.println("in starvation lock1 call");
        Future<String> submit = executorService.submit(new StarvationLock2());
        return "success:" + submit.get();
        //return "lock1 success.";
    }


}
