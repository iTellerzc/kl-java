package com.iteller.kl.netty.epoll;

import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/14 11:30
 * description:
 */
public class EpollAdapter {

    public static Class<? extends ServerSocketChannel> select(){
        boolean available = Epoll.isAvailable();
        if(available){
            return EpollServerSocketChannel.class;
        }
        return NioServerSocketChannel.class;
    }
}
