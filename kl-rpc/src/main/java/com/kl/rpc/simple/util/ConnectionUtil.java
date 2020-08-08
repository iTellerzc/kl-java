package com.kl.rpc.simple.util;

import com.kl.rpc.simple.connection.Connection;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author iTeller_zc (000601)
 * @date 2020/8/8 9:50
 * description:
 **/
public class ConnectionUtil {

    public static Connection getConnectionFromChannel(Channel channel) {
        if (channel == null) {
            return null;
        }

        Attribute<Connection> connAttr = channel.attr(Connection.CONNECTION);
        if (connAttr != null) {
            Connection connection = connAttr.get();
            return connection;
        }
        return null;
    }
}
