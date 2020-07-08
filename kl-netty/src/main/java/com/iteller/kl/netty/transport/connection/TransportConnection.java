package com.iteller.kl.netty.transport.connection;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 10:09
 * description:
 */
public abstract class TransportConnection {

    /**
     * address
     */
    private String host;

    /**
     * port
     */
    private int port;

    /**
     * 是否存活
     * @return
     */
    protected abstract boolean isActive();

    /**
     * 关闭连接
     */
    protected abstract void close();

}
