package com.kl.data.mybatis;

import com.kl.data.jdbc.service.impl.JdbcTxServiceImpl;
import com.kl.data.model.Obj1;
import com.kl.data.model.Obj2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/7 19:35
 * description:
 */
public class JdbcTxServiceMain {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kl-data-jdbc-config-test.xml");
        context.refresh();

        JdbcTxServiceImpl jdbcTxService = context.getBean("jdbcTxService", JdbcTxServiceImpl.class);

        Obj1 obj1 = new Obj1();
        obj1.setName("jdbcName1Main");

        Obj2 obj2 = new Obj2();
        obj2.setName("jdbcName2Main");
        jdbcTxService.add(obj1, obj2);

        context.close();
    }
}
