package com.kl.data.jdbc.dao.impl;

import com.kl.data.jdbc.dao.JdbcObjDao;
import com.kl.data.model.Obj1;
import com.kl.data.model.Obj2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/7 19:04
 * description:
 */
@Component
public class JdbcObjDaoImpl implements JdbcObjDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void persist(Obj1 obj1, Obj2 obj2) {
        String insertSql1 = "insert into obj1(name) values('" + obj1.getName() + "')";
        String insertSql2 = "insert into obj2(name) values('" + obj2.getName() + "')";

        jdbcTemplate.execute(insertSql1);
        jdbcTemplate.execute(insertSql2);

        throw new RuntimeException("jdbc insert exception.");
    }

    @Override
    public void persistWithNoTransactional(Obj1 obj1, Obj2 obj2) {
        String insertSql1 = "insert into obj1(name) values('" + obj1.getName() + "')";
        String insertSql2 = "insert into obj2(name) values('" + obj2.getName() + "')";

        jdbcTemplate.execute(insertSql1);
        jdbcTemplate.execute(insertSql2);

        throw new RuntimeException("jdbc insert exception with no transaction.");
    }
}
