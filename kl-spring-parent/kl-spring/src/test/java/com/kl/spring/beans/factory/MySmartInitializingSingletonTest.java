package com.kl.spring.beans.factory;

import com.kl.spring.service.smart.SmartIntializingSingletonService1;
import com.kl.spring.service.smart.SmartIntializingSingletonService2;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 9:56
 * description:
 */
@ComponentScan(basePackages = {"com.iteller.kl.spring"})
public class MySmartInitializingSingletonTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MySmartInitializingSingletonTest.class);
        System.out.println("start spring context!");
        context.refresh();
        System.out.println("spring context started!");
    }

    @Test
    public void testCallBack(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("mySmartInitializingSingleton",
                BeanDefinitionBuilder.genericBeanDefinition(MySmartInitializingSingleton.class).getBeanDefinition());

        factory.registerBeanDefinition("smartSingletonService1",
                BeanDefinitionBuilder.genericBeanDefinition(SmartIntializingSingletonService1.class).getBeanDefinition());

        factory.registerBeanDefinition("smartSingletonService2",
                BeanDefinitionBuilder.genericBeanDefinition(SmartIntializingSingletonService2.class)
                        .setLazyInit(true).
                        getBeanDefinition());

        /**
         * 触发并通知回调
         */
        factory.preInstantiateSingletons();
    }
}
