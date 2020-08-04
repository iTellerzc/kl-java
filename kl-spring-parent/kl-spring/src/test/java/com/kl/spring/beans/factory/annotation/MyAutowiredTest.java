package com.kl.spring.beans.factory.annotation;

import com.kl.spring.beans.factory.config.MySmartInstaniationAwareBeanPostProcessor;
import com.kl.spring.pojo.Person;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/16 9:31
 * description:
 */
public class MyAutowiredTest {

    @Test
    public void test(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.addBeanPostProcessor(new MySmartInstaniationAwareBeanPostProcessor());

        factory.registerBeanDefinition("name",
                BeanDefinitionBuilder.genericBeanDefinition(String.class).addConstructorArgValue("iteller")
        .getBeanDefinition());

        /*factory.registerBeanDefinition("name",
                BeanDefinitionBuilder.genericBeanDefinition(String.class).addConstructorArgValue("tracy")
                        .getBeanDefinition());*/

        factory.registerBeanDefinition("age", BeanDefinitionBuilder.genericBeanDefinition(Integer.class)
        .addConstructorArgValue(30).getBeanDefinition());

        factory.registerBeanDefinition("person", BeanDefinitionBuilder.genericBeanDefinition(Person.class).getBeanDefinition());

        Person person = factory.getBean("person", Person.class);
        System.out.println(person);
    }
}
