package com.iteller.kl.data.jdbc.service;

import com.iteller.kl.data.model.Obj1;
import com.iteller.kl.data.model.Obj2;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/7 18:01
 * description:
 */
public interface JdbcTxService {

    void add(Obj1 obj1, Obj2 obj2);

    void addWithNoTransaction(Obj1 obj1, Obj2 obj2);
}
