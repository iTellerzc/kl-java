package com.iteller.kl.netty.transport.connection;

import io.netty.channel.Channel;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 10:11
 * description:
 */
public class NettyTransportConnection extends TransportConnection{

    private Channel channel;

    @Override
    protected boolean isActive() {
        if(channel == null){
            return false;
        }

        return channel.isActive();
    }

    @Override
    protected void close() {
        if(isActive()){
            channel.close();
        }
    }
}
