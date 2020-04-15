package com.iteller.kl.spring.service;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/15 16:23
 * description:
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Primary
@Lazy
public class Service1 {
}
