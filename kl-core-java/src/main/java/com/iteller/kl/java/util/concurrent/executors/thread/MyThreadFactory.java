package com.iteller.kl.java.util.concurrent.executors.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author:18060903(iTeller_zc)
 * date:2019/12/5 10:19
 * description:
 */
public class MyThreadFactory implements ThreadFactory {

    private final String prefix;

    private final boolean daemon;

    private static final AtomicInteger di = new AtomicInteger(1);

    private final AtomicInteger ai = new AtomicInteger(1);

    public MyThreadFactory(){
        this("demo" + di.getAndIncrement(), false);
    }

    public MyThreadFactory(String prefix, boolean daemon){
        this.daemon = daemon;
        this.prefix = prefix;
    }

    public Thread newThread(Runnable r) {
        String name = prefix + ai.getAndIncrement() + "-thread";
        Thread thread = new Thread(r, name);
        thread.setDaemon(daemon);
        return thread;
    }
}
