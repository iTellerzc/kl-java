package com.iteller.kl.data.jdbc.dao;

import com.iteller.kl.data.model.Obj1;
import com.iteller.kl.data.model.Obj2;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/7 19:03
 * description:
 */
public interface JdbcObjDao {

    void persist(Obj1 obj1, Obj2 obj2);

    void persistWithNoTransactional(Obj1 obj1, Obj2 obj2);
}
