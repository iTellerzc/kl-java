package com.iteller.kl.spring.boot.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/2 9:45
 * description:
 */
@SpringBootApplication(scanBasePackages = {"com.iteller.kl.spring.boot"})
public class BootApplicationTest {

    public static void main(String[] args){
        SpringApplication.run(BootApplicationTest.class, args);
        System.out.println("test spring boot application started!");
    }
}
