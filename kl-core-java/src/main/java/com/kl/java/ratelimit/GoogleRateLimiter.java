package com.kl.java.ratelimit;


import com.google.common.util.concurrent.RateLimiter;

/**
 * @author iTeller_zc
 * date:2020/4/14
 * description:
 */
public class GoogleRateLimiter {

    public static void main(String[] args){
        RateLimiter rateLimiter = RateLimiter.create(5);
        for (int i=0; i<10; i++){
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
        }

        System.out.println("-------------");
        rateLimiter.setRate(10);
        for (int i=0; i<10; i++){
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
        }

    }
}
