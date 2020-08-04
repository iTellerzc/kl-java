package com.kl.spring.beans.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/25 14:33
 * description:
 */
public class MyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new String("this is my factory bean");
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }
}
