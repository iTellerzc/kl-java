package com.iteller.kl.spring.service;

import com.iteller.kl.spring.service.destroy.MyDestroyServiceSummary;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 11:05
 * description:
 */
@Configurable
public class MyDestroyServiceSummaryTest {

    @Bean(destroyMethod = "selfDestroy")
    public MyDestroyServiceSummary myDestroyServiceSummary(){
        return new MyDestroyServiceSummary();
    }

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyDestroyServiceSummaryTest.class);
        System.out.println("start spring application context.");
        context.refresh();
        System.out.println("spring application context started.");
        System.out.println("bean:" + context.getBean(MyDestroyServiceSummary.class));
        //close
        System.out.println("prepare to close spring application context...");
        context.close();
        System.out.println("spring application context shutdown.");

    }
}
