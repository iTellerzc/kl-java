package com.iteller.kl.spring.service.aop;

import com.iteller.kl.spring.pojo.aop.Person;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/14 9:51
 * description:
 */
public interface PersonService {

    Person getPerson(String name, int age);
}
