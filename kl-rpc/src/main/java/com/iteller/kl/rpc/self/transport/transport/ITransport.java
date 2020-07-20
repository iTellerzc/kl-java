package com.iteller.kl.rpc.self.transport.transport;

import com.iteller.kl.rpc.self.transport.connection.TransportConnection;
import com.iteller.kl.rpc.self.transport.future.TransportCallBack;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 10:00
 * description:
 */
public interface ITransport {

    /**
     * 同步调用
     * @param transportConnection
     * @return
     */
    Object invoke(TransportConnection transportConnection);

    /**
     * 异步调用
     * @param transportConnection
     * @param transportCallBack
     */
    void asyncInvoke(TransportConnection transportConnection, TransportCallBack transportCallBack);

}
