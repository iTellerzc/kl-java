package com.kl.spring.beans.factory;

import com.kl.spring.pojo.Car;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 14:24
 * description:
 *
 */
public class MyBeanDefinitionBuilder {

    public static void main(String[] args){
        //like <bean class="**.Car"></bean>
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Car.class);

        builder.addPropertyValue("name", "tesla");//属性赋值
        BeanDefinition beanDefinition = builder.getBeanDefinition();

        System.out.println(beanDefinition);
    }
}
