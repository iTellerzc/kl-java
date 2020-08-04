package com.kl.spring.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 9:15
 * description:
 */
public class MyPostConstructAndAware implements EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware {

    @PostConstruct
    public void postConstruct1(){
        System.out.println("pc1");
    }


    @PostConstruct
    public void postConstruct2(){
        System.out.println("pc2");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("set application context:" + applicationContext);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("set application event publisher:" + applicationEventPublisher);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("set embedded value resolver:" + resolver);
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("set environment:" + environment);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("set message source:" + messageSource);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("set resource loader:" + resourceLoader);
    }
}
