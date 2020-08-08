package com.kl.rpc.simple.connection;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

/**
 * @author iTeller_zc (000601)
 * @date 2020/8/8 9:27
 * description:channel wrapper
 **/
public class Connection {

    private Channel channel;

    public static final AttributeKey<Connection> CONNECTION = AttributeKey.valueOf("connection");


}
