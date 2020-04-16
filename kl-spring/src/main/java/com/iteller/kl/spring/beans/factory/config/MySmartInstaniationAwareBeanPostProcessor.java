package com.iteller.kl.spring.beans.factory.config;

import com.iteller.kl.spring.beans.factory.annotation.MyAutowired;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/16 9:23
 * description:
 */
public class MySmartInstaniationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println(beanClass);
        System.out.println("invoke MySmartInstaniationAwareBeanPostProcessor.determineCandidateConstructors method");
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        if (declaredConstructors != null){
            List<Constructor<?>> collect = Arrays.stream(declaredConstructors)
                    .filter(constructor -> constructor.isAnnotationPresent(MyAutowired.class))
                    .collect(Collectors.toList());
            Constructor[] constructors = collect.toArray(new Constructor[0]);
            return constructors.length != 0 ? constructors : null;
        }
        return null;
    }
}
