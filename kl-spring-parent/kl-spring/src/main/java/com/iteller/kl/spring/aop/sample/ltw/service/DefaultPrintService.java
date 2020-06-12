package com.iteller.kl.spring.aop.sample.ltw.service;

import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/14 17:03
 * description:
 */
public class DefaultPrintService implements PrintService {

    @Override
    public void printName(String name) {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
