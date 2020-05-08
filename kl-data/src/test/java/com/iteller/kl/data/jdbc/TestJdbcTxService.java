package com.iteller.kl.data.jdbc;

import com.iteller.kl.data.jdbc.service.JdbcTxService;
import com.iteller.kl.data.model.Obj1;
import com.iteller.kl.data.model.Obj2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/7 19:11
 * description:
 */
@ContextConfiguration(locations = {"classpath:kl-data-jdbc-config-test.xml"})
public class TestJdbcTxService extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private JdbcTxService jdbcTxService;

    @Test
    @Rollback(value = false)
    public void testJdbcTx(){
        Obj1 obj1 = new Obj1();
        obj1.setName("jdbcName1");

        Obj2 obj2 = new Obj2();
        obj2.setName("jdbcName2");

        jdbcTxService.add(obj1, obj2);
    }

    @Test
    @Rollback(value = false) //不回滚
    public void testJdbcNoRollback(){
        Obj1 obj1 = new Obj1();
        obj1.setName("jdbcName1NoTransaction");

        Obj2 obj2 = new Obj2();
        obj2.setName("jdbcName2NoTransaction");

        jdbcTxService.addWithNoTransaction(obj1, obj2);
    }

    @Test
    //@Transactional
    public void testTransactionalJdbc(){
        Obj1 obj1 = new Obj1();
        obj1.setName("jdbcName1WithTransaction");

        Obj2 obj2 = new Obj2();
        obj2.setName("jdbcName2WithTransaction");

        jdbcTxService.addWithNoTransaction(obj1, obj2);
    }
}
