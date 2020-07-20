package com.iteller.kl.rpc.self.transport.serializer;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/14 17:07
 * description:传输序列化
 */
public interface TransportSerializer {

    /**
     * 序列化
     * @param obj
     * @return
     */
    byte[] serializer(Object obj);

    /**
     * 反序列化
     * @param obj
     * @param clazz
     * @return
     */
    <T> T deserializer(byte[] obj, Class<T> clazz);
}
