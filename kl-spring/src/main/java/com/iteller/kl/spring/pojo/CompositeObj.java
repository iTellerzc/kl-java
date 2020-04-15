package com.iteller.kl.spring.pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 15:09
 * description:
 */
public class CompositeObj {

    private String name;

    private Integer salary;

    private Car car;

    private List<String> stringList;

    private List<Car> carList;

    private Set<String> stringSet;

    private Set<Car> carSet;

    private Map<String, String> stringMap;

    private Map<String, Car> carMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public Map<String, Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(Map<String, Car> carMap) {
        this.carMap = carMap;
    }

    @Override
    public String toString() {
        return "CompositeObj{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", car=" + car +
                ", stringList=" + stringList +
                ", carList=" + carList +
                ", stringSet=" + stringSet +
                ", carSet=" + carSet +
                ", stringMap=" + stringMap +
                ", carMap=" + carMap +
                '}';
    }
}
