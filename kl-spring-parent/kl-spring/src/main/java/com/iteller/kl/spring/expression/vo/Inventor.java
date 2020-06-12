package com.iteller.kl.spring.expression.vo;

import java.util.Date;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/12 17:12
 * description:
 */
public class Inventor {

    private String name;

    private Date date;

    private String country;

    public Inventor(String name, Date date, String country) {
        this.name = name;
        this.date = date;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
