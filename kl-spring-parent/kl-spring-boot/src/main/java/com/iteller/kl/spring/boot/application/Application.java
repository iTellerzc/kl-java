package com.iteller.kl.spring.boot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/19 19:25
 * description:
 */
@SpringBootApplication  //same as //@EnableAutoConfiguration //@ComponentScan //@Configuration
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
