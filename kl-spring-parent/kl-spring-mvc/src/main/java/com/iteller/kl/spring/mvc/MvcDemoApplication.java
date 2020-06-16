package com.iteller.kl.spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/16 10:01
 * description:
 */
//无持久层
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
public class MvcDemoApplication {

    public static void main(String[] args){
        SpringApplication.run(MvcDemoApplication.class, args);
        System.out.println("spring mvc sample started!");
    }
}
