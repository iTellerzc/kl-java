package com.iteller.kl.spring.beans.factory.support;

import com.iteller.kl.spring.service.replace.MyReplacer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author iTeller_zc
 * date:2020/4/19
 * description:
 */
public class MyReplacerTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-replace.xml");
        context.refresh();

        MyReplacer replacer = context.getBean("myReplacer", MyReplacer.class);
        System.out.println(replacer.replace("input"));

        context.close();
    }
}
