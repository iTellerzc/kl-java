package com.kl.spring.beans.factory.support;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author iTeller_zc
 * date:2020/4/19
 * description:
 */
public class MyMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("this is real invoke!");
        String input = (String) args[0];
        return input;
    }
}
