package com.iteller.kl.netty.transport.factory;

import com.iteller.kl.netty.consts.SerializableTypes;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/15 9:24
 * description:
 */
public class TransportSerializerFactoryTest {

    @Test
    public void testCreateByType() throws Exception {
        TransportSerializerFactory.createByType(SerializableTypes.HESSIAN);
    }

}