package com.iteller.kl.java.util.concurrent.executors.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author:18060903(iTeller_zc)
 *
 * date:2020/3/6 17:37
 * description:
 */
public class ScheduleExecutorsServiceTest {

    public static void main(String[] args){
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(new MyRunnable("name1"), 10, 2, TimeUnit.SECONDS);

        ses.scheduleWithFixedDelay(new MyRunnable("name2"), 20, 3, TimeUnit.SECONDS);
    }
}
