package com.iteller.kl.spring.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/16 20:20
 * description:
 */
public class MyBeanAware implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware {

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("注入classloader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("注入beanfactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("注入name");
    }
}
