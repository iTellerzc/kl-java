package com.kl.spring.aop.sample.person;

import com.kl.spring.service.aop.PersonService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/14 10:05
 * description:
 */
public class PersonBoot {

    public static void main(String[] args){
        BeanFactory factory = new ClassPathXmlApplicationContext("aop/aop-person-config-test.xml");
        PersonService personService = factory.getBean("personService", PersonService.class);
        personService.getPerson("iTeller_zc", 29);
    }
}
