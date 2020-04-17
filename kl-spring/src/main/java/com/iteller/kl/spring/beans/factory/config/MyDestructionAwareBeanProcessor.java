package com.iteller.kl.spring.beans.factory.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 10:43
 * description:
 */
public class MyDestructionAwareBeanProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        System.out.println("prepare destroy " + beanName);
    }
}
