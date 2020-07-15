package com.iteller.kl.netty.transport.serializer;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;
import com.iteller.kl.common.enums.KlExceptionEnums;
import com.iteller.kl.netty.exception.TransportRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/14 19:24
 * description:缺省hessian序列化
 */
public class HessianTransportSerializer implements TransportSerializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HessianTransportSerializer.class);

    private SerializerFactory factory = new SerializerFactory();

    public HessianTransportSerializer(){

    }

    @Override
    public byte[] serializer(Object obj) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(baos);
        output.setSerializerFactory(factory);
        try {
            output.writeObject(obj);
            output.close();
        } catch (IOException e) {
            LOGGER.error("hessian serializer error!", e);
            throw new TransportRpcException(KlExceptionEnums.SERIALIZER_ERROR, e);
        }
        byte[] result = baos.toByteArray();
        return result;
    }

    @Override
    public <T> T deserializer(byte[] obj, Class<T> clazz) {
        Hessian2Input input = new Hessian2Input(new ByteArrayInputStream(obj));
        input.setSerializerFactory(factory);
        Object resultObj;
        try {
            resultObj = input.readObject(clazz);
            input.close();
        } catch (IOException e) {
            LOGGER.error("hessian deserializer error!", e);
            throw new TransportRpcException(KlExceptionEnums.DESERIALIZER_ERROR, e);
        }
        return (T) resultObj;
    }
}
