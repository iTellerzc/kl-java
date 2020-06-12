package com.iteller.kl.spring.pojo;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 14:24
 * description:
 */
public class Car {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
