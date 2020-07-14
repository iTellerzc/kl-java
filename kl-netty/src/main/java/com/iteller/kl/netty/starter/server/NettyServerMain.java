package com.iteller.kl.netty.starter.server;

import com.iteller.kl.netty.exception.NettyException;
import com.iteller.kl.netty.helper.NettyServerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:18
 * description:
 */
public class NettyServerMain {

    private static final String PORT = "8888";

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyServerMain.class);

    public static void main(String[] args){

        NettyServerHelper nettyServerHelper = new NettyServerHelper(Integer.valueOf(PORT));
        try {
             boolean started = nettyServerHelper.start();
             if(started){
                 LOGGER.info("netty server main started successfully, port:{}!", PORT);
             }
        } catch (InterruptedException e) {
            LOGGER.error("netty server start meet error.", e);
            Thread.interrupted();
            nettyServerHelper.stop();
            throw new NettyException(e);
        }

    }
}
