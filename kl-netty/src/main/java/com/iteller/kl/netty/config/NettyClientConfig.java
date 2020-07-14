package com.iteller.kl.netty.config;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/14 10:50
 * description:
 */
public class NettyClientConfig extends NettyConfig {

    /**
     * 超时时间(ms)
     */
    private long timeOut = 1000;

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public NettyClientConfig() {
        super();
    }

    public NettyClientConfig(long idle, int coreThreadSize, int maxThreadSize, int queueSize, long threadKeepAlive, long timeOut) {
        super(idle, coreThreadSize, maxThreadSize, queueSize, threadKeepAlive);
        this.timeOut = timeOut;
    }
}
