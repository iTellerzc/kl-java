package com.kl.test.op;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/3 16:37
 * description:
 */
public class ThreadPoolExecutorOpTest {
    private static final int COUNT_BITS = Integer.SIZE - 3;

    private static final int CAPACITY = (1 << COUNT_BITS) -1;

    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWM = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    private static final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    private static int runStateOf(int c){
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c)  { return c & CAPACITY; }

    public static void main(String[] args){
        System.out.println("running:" + RUNNING);
        System.out.println("shutdown:" + SHUTDOWM);
        System.out.println("stop:" + STOP);
        System.out.println("tidying:" + TIDYING);
        System.out.println("terminated:" + TERMINATED);

        System.out.println("init ctl:" + ctl.get());
    }

    private static int ctlOf(int runningState, int wc) {
        return runningState | wc;
    }
}
