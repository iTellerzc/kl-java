package com.iteller.kl.spring.pojo;

import com.iteller.kl.spring.beans.factory.annotation.MyAutowired;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/16 9:19
 * description:
 */
public class Person {

    private String name;

    private Integer age;

    public Person(){
        System.out.println("invoke person()");
    }

    @MyAutowired
    public Person(String name){
        this.name = name;
        System.out.println("invoke person(string name)");
    }

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
        System.out.println("invoke person(string name, int age)");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
