package com.iteller.kl.rpc.self.helper;

import com.iteller.kl.rpc.self.epoll.EpollAdapter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/14 10:41
 * description:
 */
public class TransportServerHelper {
    private int port = 8888;

    private ServerBootstrap serverBootstrap;

    private EventLoopGroup bossGroup;

    private EventLoopGroup workGroup;

    private ChannelFuture channelFuture;

    public TransportServerHelper(int port){
        this.port = port;
    }

    public boolean start() throws InterruptedException {

        serverBootstrap = new ServerBootstrap();
        bossGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors());
        workGroup = new NioEventLoopGroup();
        serverBootstrap.group(bossGroup, workGroup);

        //option and config
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        serverBootstrap.option(ChannelOption.TCP_NODELAY, true);

        //channel
        serverBootstrap.channel(EpollAdapter.select());

        //handler
        //serverBootstrap.handler();

        //biz handler
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                //codec todo

                //biz handler todo
            }

        });

        this.channelFuture = serverBootstrap.bind(port).sync();
        return channelFuture.isSuccess();
    }

    public void stop(){
        if(null != channelFuture){
            channelFuture.channel().close();
        }
        if(null != bossGroup){
            bossGroup.shutdownGracefully();
        }

        if(null != workGroup){
            workGroup.shutdownGracefully();
        }
    }
}
