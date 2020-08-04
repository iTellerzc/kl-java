package com.kl.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 16:28
 * description:
 */
public class Service2 {

    @Autowired
    private Service1 service1;

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
