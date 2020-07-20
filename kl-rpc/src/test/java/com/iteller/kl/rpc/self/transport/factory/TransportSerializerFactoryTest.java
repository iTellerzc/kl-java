package com.iteller.kl.rpc.self.transport.factory;

import com.iteller.kl.rpc.self.consts.SerializableTypes;
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