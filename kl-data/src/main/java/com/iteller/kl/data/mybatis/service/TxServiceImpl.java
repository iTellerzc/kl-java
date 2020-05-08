package com.iteller.kl.data.mybatis.service;

import com.iteller.kl.data.model.Obj1;
import com.iteller.kl.data.model.Obj2;
import com.iteller.kl.data.mybatis.mapper.Obj1Mapper;
import com.iteller.kl.data.mybatis.mapper.Obj2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/7 16:33
 * description:
 */
@Service
public class TxServiceImpl implements TxService {

    @Autowired
    private Obj1Mapper obj1Mapper;

    @Autowired
    private Obj2Mapper obj2Mapper;

    @Override
    public void add(Obj1 obj1, Obj2 obj2) {
        obj1Mapper.add(obj1);

        obj2Mapper.add(obj2);

        throw new RuntimeException("mybatis insert exception!");
    }
}
