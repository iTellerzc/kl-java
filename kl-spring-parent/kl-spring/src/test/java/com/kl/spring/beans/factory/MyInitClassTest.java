package com.kl.spring.beans.factory;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 9:31
 * description:
 */
public class MyInitClassTest {

    @Test
    public void test(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(MyInitClass.class)
                .setInitMethodName("init")
                .getBeanDefinition();

        factory.registerBeanDefinition("myInit", beanDefinition);

        System.out.println(factory.getBean("myInit"));
    }
}
