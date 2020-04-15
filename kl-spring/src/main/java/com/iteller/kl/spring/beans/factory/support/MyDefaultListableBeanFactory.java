package com.iteller.kl.spring.beans.factory.support;

import com.iteller.kl.spring.pojo.Car;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 14:31
 * description:
 */
public class MyDefaultListableBeanFactory {

    public static void main(String[] args){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Car.class);
        builder.addPropertyValue("name", "tesla");//属性赋值
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        System.out.println(beanDefinition);

        //spring容器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //注册bean
        factory.registerBeanDefinition("car", beanDefinition);

        //获取bean
        Car car = factory.getBean("car", Car.class);

        //使用bean
        System.out.println(car);

    }
}
