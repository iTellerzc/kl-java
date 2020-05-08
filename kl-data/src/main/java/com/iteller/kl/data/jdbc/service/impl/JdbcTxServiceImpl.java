package com.iteller.kl.data.jdbc.service.impl;

import com.iteller.kl.data.jdbc.dao.JdbcObjDao;
import com.iteller.kl.data.jdbc.service.JdbcTxService;
import com.iteller.kl.data.model.Obj1;
import com.iteller.kl.data.model.Obj2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/7 18:02
 * description:
 */
@Service("jdbcTxService")
public class JdbcTxServiceImpl implements JdbcTxService {

    @Autowired
    private JdbcObjDao jdbcObjDao;

    @Override
    public void add(Obj1 obj1, Obj2 obj2) {
        jdbcObjDao.persist(obj1, obj2);
    }

    @Override
    public void addWithNoTransaction(Obj1 obj1, Obj2 obj2) {
        jdbcObjDao.persistWithNoTransactional(obj1, obj2);
    }
}
