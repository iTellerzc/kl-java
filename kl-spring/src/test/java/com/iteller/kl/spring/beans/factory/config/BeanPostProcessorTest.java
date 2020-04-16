package com.iteller.kl.spring.beans.factory.config;

import com.iteller.kl.spring.pojo.Car;
import com.iteller.kl.spring.pojo.UserModel;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
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
}
