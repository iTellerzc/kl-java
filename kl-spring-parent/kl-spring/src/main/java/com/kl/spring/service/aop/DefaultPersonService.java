package com.kl.spring.service.aop;

import com.kl.spring.pojo.aop.Person;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/14 9:53
 * description:
 */
public class DefaultPersonService implements PersonService {

    @Override
    public Person getPerson(String name, int age) {
        return new Person(name, age);
    }
}
