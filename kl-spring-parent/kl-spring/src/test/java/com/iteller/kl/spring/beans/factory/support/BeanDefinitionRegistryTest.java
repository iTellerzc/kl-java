package com.iteller.kl.spring.beans.factory.support;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 16:52
 * description:
 */
public class BeanDefinitionRegistryTest {

    @Test
    public void test(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //定义一个bean
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(String.class);
        beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, "iteller");

        //注册bean
        factory.registerBeanDefinition("name", beanDefinition);

        //bean definition
        System.out.println(factory.getBeanDefinition("name"));
        //是否注册过
        System.out.println(factory.containsBeanDefinition("name"));
        //获取所有注册的名称
        System.out.println(Arrays.asList(factory.getBeanDefinitionNames()));
        //数量
        System.out.println(factory.getBeanDefinitionCount());
        //是否使用过
        System.out.println(factory.isBeanNameInUse("name"));

        //alias
        factory.registerAlias("name", "alias-name-1");
        factory.registerAlias("name", "alias-name-2");

        System.out.println(Arrays.asList(factory.getAliases("name")));

        System.out.println(factory.getBean("name"));

    }
}
