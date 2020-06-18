package com.iteller.kl.design.pattern.reflect.pojo;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/16 20:10
 * description:
 */
public class PersonTest {

    public static void main(String[] args){
        Class clz = Person.class;
        System.out.println(clz.getClass());
        System.out.println(new Person().getClass());

        try {
            Class clz1 = Class.forName("com.iteller.kl.design.pattern.reflect.pojo.Person");
            System.out.println(clz1.getClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}