package com.kl.spring.pojo;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 14:42
 * description:
 */
public class User {

    private String name;

    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
