package com.kl.spring.beans.factory.support;

import com.kl.spring.pojo.Car;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 14:46
 * description:
 */
public class BeanDefinitionBuilderTest {

    @Test
    public void test(){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Car.class);
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        System.out.println(beanDefinition);
    }
}
