package com.kl.spring.beans.factory;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/16 20:21
 * description:
 */
public class MyBeanAwareTest {

    @Test
    public void test(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.registerBeanDefinition("beanAware", BeanDefinitionBuilder.genericBeanDefinition(MyBeanAware.class).getBeanDefinition());

        System.out.println(factory.getBean("beanAware"));
    }
}
