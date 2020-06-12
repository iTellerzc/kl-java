package com.iteller.kl.spring.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/16 9:17
 * description:
 */
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowired {

}
