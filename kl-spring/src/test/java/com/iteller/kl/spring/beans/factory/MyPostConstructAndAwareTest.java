package com.iteller.kl.spring.beans.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/17 9:21
 * description:
 */
public class MyPostConstructAndAwareTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(MyPostConstructAndAware.class);
        configApplicationContext.refresh();
    }
}
