package com.iteller.kl.spring.beans.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/25 14:32
 * description:
 */
public class MyFactoryBeanTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("factory-beans.xml");
        context.refresh();

        MyFactoryBean myFactoryBean =  context.getBean("&myBeanFactory", MyFactoryBean.class);
        System.out.println("factory bean:" + myFactoryBean);
        System.out.println(myFactoryBean.getObject());

        context.close();
    }
}
