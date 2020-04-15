package com.iteller.kl.spring.beans.factory.support;


import com.iteller.kl.spring.pojo.Car;
import com.iteller.kl.spring.pojo.CompositeObj;
import com.iteller.kl.spring.pojo.User;
import com.iteller.kl.spring.service.Service1;
import com.iteller.kl.spring.service.Service2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 14:45
 * description:
 */
public class DefaultListableBeanFactoryTest {

    @Test
    public void test(){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Car.class);
        builder.addPropertyValue("name", "tesla");//属性赋值
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        System.out.println(beanDefinition);
        //spring容器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //注册bean
        factory.registerBeanDefinition("car1", beanDefinition);
        //获取bean
        Car car = factory.getBean("car1", Car.class);
        //使用bean
        System.out.println(car);
    }


    @Test
    public void testReffer(){
        BeanDefinitionBuilder userBuilder = BeanDefinitionBuilder.rootBeanDefinition(User.class);

        BeanDefinitionBuilder carBuilder = BeanDefinitionBuilder.rootBeanDefinition(Car.class.getName());
        carBuilder.addPropertyValue("name", "muzda");
        BeanDefinition carBeanDef = carBuilder.getBeanDefinition();

        userBuilder.addPropertyReference("car", "car");//依赖bean注入
        userBuilder.addPropertyValue("name", "iteller");
        BeanDefinition userBeanDef = userBuilder.getBeanDefinition();

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("car", carBeanDef);
        factory.registerBeanDefinition("user", userBeanDef);

        Car car = factory.getBean("car", Car.class);
        User user = factory.getBean("user", User.class);
        System.out.println(car);
        System.out.println(user);
    }

    @Test
    public void testParent(){
        BeanDefinition parent = BeanDefinitionBuilder
                .genericBeanDefinition(Car.class)
                .addPropertyValue("name", "audi")
                .getBeanDefinition();

        BeanDefinition child = BeanDefinitionBuilder.genericBeanDefinition(Car.class)
                .setParentName("carParent")
                .getBeanDefinition();

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.registerBeanDefinition("carParent", parent);
        factory.registerBeanDefinition("carChild", child);

        Car p = factory.getBean("carParent", Car.class);
        Car c = factory.getBean("carChild", Car.class);
        System.out.println(p);
        System.out.println(c);

    }

    @Test
    public void testCompositeBean(){
        BeanDefinition car1 = BeanDefinitionBuilder.genericBeanDefinition(Car.class)
                .addPropertyValue("name", "tesla")
                .getBeanDefinition();

        BeanDefinition car2 = BeanDefinitionBuilder.genericBeanDefinition(Car.class)
                .addPropertyValue("name", "audi")
                .getBeanDefinition();

        //composite bean
        //string list
        ManagedList<String> stringList = new ManagedList<>();
        stringList.addAll(Arrays.asList("java", "python"));

        //car list
        ManagedList<RuntimeBeanReference> carList = new ManagedList<>();
        carList.add(new RuntimeBeanReference("car1"));
        carList.add(new RuntimeBeanReference("car2"));

        //string set
        ManagedSet<String> stringSet = new ManagedSet<>();
        stringSet.addAll(Arrays.asList("java", "python"));

        //car set
        ManagedSet<RuntimeBeanReference> carSet = new ManagedSet<>();
        carSet.add(new RuntimeBeanReference("car1"));
        carSet.add(new RuntimeBeanReference("car2"));

        //map string
        ManagedMap<String, String> stringMap = new ManagedMap<>();
        stringMap.put("java", "java");
        stringMap.put("python", "python");

        //map car
        ManagedMap<String, RuntimeBeanReference> carMap = new ManagedMap<>();
        carMap.put("car1", new RuntimeBeanReference("car1"));
        carMap.put("car2", new RuntimeBeanReference("car2"));

        GenericBeanDefinition compositeBeanDef = new GenericBeanDefinition();
        compositeBeanDef.setBeanClassName(CompositeObj.class.getName());

        compositeBeanDef.getPropertyValues().add("name", "iteller")
                .add("salary", 1000)
                .add("car", new RuntimeBeanReference("car1"))
                .add("stringList", stringList)
                .add("carList", carList)
                .add("stringSet", stringSet)
                .add("carSet", carSet)
                .add("stringMap", stringMap)
                .add("carMap", carMap);

        //spring容器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("car1", car1);//注册bean
        factory.registerBeanDefinition("car2", car2);//注册bean
        factory.registerBeanDefinition("compositeObj", compositeBeanDef);//注册bean

        for (String beanName : factory.getBeanDefinitionNames()){
            System.out.println(factory.getBean(beanName));
        }
    }

    @Test
    public void testXmlBeanDefinitionReader(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        String location = "classpath:beans-composite.xml";
        int beanCount = reader.loadBeanDefinitions(location);
        System.out.println("beanCount:" + beanCount);

        for(String beanName : factory.getBeanDefinitionNames()){
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            String beanDefinitionClassName = beanDefinition.getClass().getName();
            Object bean = factory.getBean(beanName);

            System.out.println("beanName:" + beanName);
            System.out.println("beanDefinition:" + beanDefinition);
            System.out.println("beanDefinitionClassName:" + beanDefinitionClassName);
            System.out.println("bean:" + bean);
        }
    }

    @Test
    public void testAnnotatedBeanDefinitionReader(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(factory);

        reader.register(Service1.class, Service2.class);

        //service1=null
        factory.getBeansOfType(BeanPostProcessor.class).values().forEach(factory :: addBeanPostProcessor);

        for(String beanName : new String[]{"service1", "service2"}){
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            String beanDefinitionClassName = beanDefinition.getClass().getName();
            Object bean = factory.getBean(beanName);

            System.out.println("beanName:" + beanName);
            System.out.println("beanDefinition:" + beanDefinition);
            System.out.println("beanDefinitionClassName:" + beanDefinitionClassName);
            System.out.println("bean:" + bean);

        }


    }
}
