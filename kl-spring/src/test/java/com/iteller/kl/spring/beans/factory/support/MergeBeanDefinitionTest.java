package com.iteller.kl.spring.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 17:24
 * description:
 */
public class MergeBeanDefinitionTest {

    @Test
    public void test(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions("classpath:lesson-beans.xml");

        for(String beanName : factory.getBeanDefinitionNames()){
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            BeanDefinition mergedBeanDefinition = factory.getMergedBeanDefinition(beanName);

            System.out.println(beanName);
            System.out.println("解析xml过程中注册的beanDefinition:" + beanDefinition);
            System.out.println("beanDefinition属性信息:" + beanDefinition.getPropertyValues());
            System.out.println("合并后的beanDefinition:" + mergedBeanDefinition);
            System.out.println("合并后的definition属性:" + mergedBeanDefinition.getPropertyValues());
            System.out.println("---end---");
        }

    }
}
