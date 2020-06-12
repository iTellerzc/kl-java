package com.iteller.kl.spring.boot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/19 17:29
 * description:
 */
@Deprecated
@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    public String home(){
        return "this is first spring boot demo page!";
    }

    public static void main(String[] args){
        SpringApplication.run(Example.class, args);
    }
}
