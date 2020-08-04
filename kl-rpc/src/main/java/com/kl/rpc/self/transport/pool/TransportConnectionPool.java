package com.kl.rpc.self.transport.pool;

import com.kl.rpc.self.transport.connection.DefaultTransportConnection;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 10:20
 * description:
 */
public class TransportConnectionPool {

    public DefaultTransportConnection create(DefaultTransportConnection nettyTransportConnection){
        return nettyTransportConnection;
    }

    public DefaultTransportConnection get(DefaultTransportConnection nettyTransportConnection){
        return nettyTransportConnection;
    }
}
