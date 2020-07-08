package com.iteller.kl.netty.transport.pool;

import com.iteller.kl.netty.transport.connection.NettyTransportConnection;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 10:20
 * description:
 */
public class TransportConnectionPool {

    public NettyTransportConnection create(NettyTransportConnection nettyTransportConnection){
        return nettyTransportConnection;
    }

    public NettyTransportConnection get(NettyTransportConnection nettyTransportConnection){
        return nettyTransportConnection;
    }
}
