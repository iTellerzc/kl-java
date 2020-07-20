package com.iteller.kl.rpc.self.transport.factory;

import com.iteller.kl.common.enums.KlExceptionEnums;
import com.iteller.kl.common.exception.KlException;
import com.iteller.kl.rpc.self.consts.SerializableTypes;
import com.iteller.kl.rpc.self.transport.serializer.HessianTransportSerializer;
import com.iteller.kl.rpc.self.transport.serializer.TransportSerializer;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/14 17:20
 * description:序列化工厂
 */
public class TransportSerializerFactory {

    private static final TransportSerializer HESSIAN_INSTANCE = new HessianTransportSerializer();

    private TransportSerializerFactory(){

    }

    public static TransportSerializer createByType(int type){
        if(SerializableTypes.HESSIAN == type){
            return HESSIAN_INSTANCE;
        }
        throw new KlException(KlExceptionEnums.SERIALIZER_TYPE_NOT_SUPPORT, new UnsupportedOperationException());
    }

}
