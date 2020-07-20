package com.iteller.kl.rpc.self.starter.server;

import com.iteller.kl.rpc.self.exception.TransportException;
import com.iteller.kl.rpc.self.helper.TransportServerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:18
 * description:
 */
public class TransportServerMain {

    private static final String PORT = "8888";

    private static final Logger LOGGER = LoggerFactory.getLogger(TransportServerMain.class);

    public static void main(String[] args){

        TransportServerHelper transportServerHelper = new TransportServerHelper(Integer.valueOf(PORT));
        try {
             boolean started = transportServerHelper.start();
             if(started){
                 LOGGER.info("netty server main started successfully, port:{}!", PORT);
             }
        } catch (InterruptedException e) {
            LOGGER.error("netty server start meet error.", e);
            Thread.interrupted();
            transportServerHelper.stop();
            throw new TransportException(e);
        }

    }
}
