package com.kl.spring.beans.factory.config;

import com.kl.spring.pojo.Car;
import com.kl.spring.pojo.UserModel;
import com.kl.spring.service.destroy.MyDestroyService;
import com.kl.spring.service.destroy.MyDestroyServiceWithPreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.testng.annotations.Test;

import java.beans.PropertyDescriptor;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 20:02
 * description:
 */
public class BeanPostProcessorTest {

    @Test
    public void testBefore(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
                System.out.println("invoke postProcessBeforeInstantiation");
                if(beanClass == Car.class){
                    Car car = new Car();
                    car.setName("tesla");
                    return car;
                }
                return null;
            }
        });

        AbstractBeanDefinition carBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Car.class)
                .addPropertyValue("name", "audi").getBeanDefinition();
        factory.registerBeanDefinition("car", carBeanDefinition);
        System.out.println(factory.getBean("car"));

    }

    @Test
    public void testAfter(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //notice location
        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
                if(beanName.equals("user1")){
                    return false;
                }
                return true;
            }
        });

        factory.registerBeanDefinition("user1", BeanDefinitionBuilder.genericBeanDefinition(UserModel.class)
        .addPropertyValue("name", "iteller")
        .addPropertyValue("age", 30)
        .getBeanDefinition());

        factory.registerBeanDefinition("user2", BeanDefinitionBuilder.genericBeanDefinition(UserModel.class)
                .addPropertyValue("name", "tracy")
                .addPropertyValue("age", 29)
                .getBeanDefinition());

        for(String beanName : factory.getBeanDefinitionNames()){
            System.out.println(String.format("%s->%s", beanName, factory.getBean(beanName)));
        }
    }

    @Test
    public void testPropertyValues(){
        //not ok
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
                if("user1".equals(beanName)){
                    if(pvs == null){
                        pvs = new MutablePropertyValues();
                    }
                    if(pvs instanceof MutablePropertyValues){
                        MutablePropertyValues mpvs = (MutablePropertyValues) pvs;
                        mpvs.add("name", "zc");
                        mpvs.add("age", 29);
                        return mpvs;
                    }
                }
                return pvs;
            }
        });

        factory.registerBeanDefinition("user1", BeanDefinitionBuilder.genericBeanDefinition(UserModel.class)
                //.addPropertyValue("name", "iteller")
                //.addPropertyValue("age", 30)
                .getBeanDefinition());

        factory.registerBeanDefinition("user2", BeanDefinitionBuilder.genericBeanDefinition(UserModel.class)
                .addPropertyValue("name", "tracy")
                .addPropertyValue("age", 29)
                .getBeanDefinition());

        for(String beanName : factory.getBeanDefinitionNames()){
            System.out.println(String.format("%s->%s", beanName, factory.getBean(beanName)));
        }
    }

    @Test
    public void testAfterInitialization(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("invoke " + beanName + " after initialization.");
                return bean;
            }
        });

        factory.registerBeanDefinition("name", BeanDefinitionBuilder.genericBeanDefinition(String.class)
        .addConstructorArgValue("iTeller").getBeanDefinition());

        factory.registerBeanDefinition("lesson", BeanDefinitionBuilder.genericBeanDefinition(String.class)
        .addConstructorArgValue("java").getBeanDefinition());

        for(String beanName : factory.getBeanDefinitionNames()){
            System.out.println(String.format("%s -> %s", beanName, factory.getBean(beanName)));
        }
    }

    @Test
    public void testDestroy(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.addBeanPostProcessor(new MyDestructionAwareBeanProcessor());

        factory.registerBeanDefinition("destroyService1",
                BeanDefinitionBuilder.genericBeanDefinition(MyDestroyService.class).getBeanDefinition());
        factory.registerBeanDefinition("destroyService2",
                BeanDefinitionBuilder.genericBeanDefinition(MyDestroyService.class).getBeanDefinition());
        factory.registerBeanDefinition("destroyService3",
                BeanDefinitionBuilder.genericBeanDefinition(MyDestroyService.class).getBeanDefinition());

        //初始化
        factory.preInstantiateSingletons();

        System.out.println("destroy service 1");
        factory.destroySingleton("destroyService1");

        System.out.println("destroy reset service");
        factory.destroySingletons();
    }

    @Test
    public void testDestroyWithPreDestroy(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.addBeanPostProcessor(new MyDestructionAwareBeanProcessor());
        factory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());

        factory.registerBeanDefinition("destroyService",
                BeanDefinitionBuilder.genericBeanDefinition(MyDestroyServiceWithPreDestroy.class).getBeanDefinition());

        //初始化
        factory.preInstantiateSingletons();

        factory.destroySingleton("destroyService1");// no exception
        factory.destroySingleton("destroyService");

        System.out.println("destroy reset service");
        factory.destroySingletons();
    }
}
