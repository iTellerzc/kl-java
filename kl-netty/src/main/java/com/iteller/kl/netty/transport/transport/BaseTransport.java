package com.iteller.kl.netty.transport.transport;

import com.iteller.kl.netty.transport.connection.NettyTransportConnection;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 10:00
 * description:
 */
public interface BaseTransport {

    /**
     * 同步调用
     * @param nettyTransportConnection
     * @return
     */
    Object invoke(NettyTransportConnection nettyTransportConnection);

}
