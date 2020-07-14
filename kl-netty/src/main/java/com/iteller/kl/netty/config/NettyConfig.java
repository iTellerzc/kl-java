package com.iteller.kl.netty.config;

import java.util.concurrent.TimeUnit;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/14 10:49
 * description:
 */
public class NettyConfig {

    private long idle = 30*60*1000;

    /**
     * 线程相关
     */
    private int coreThreadSize = Runtime.getRuntime().availableProcessors();
    private int maxThreadSize = coreThreadSize * 2;
    private int queueSize = 100;
    private long threadKeepAlive = TimeUnit.SECONDS.toSeconds(60);

    public NettyConfig(){}

    public NettyConfig(long idle, int coreThreadSize, int maxThreadSize, int queueSize, long threadKeepAlive) {
        this.idle = idle;
        this.coreThreadSize = coreThreadSize;
        this.maxThreadSize = maxThreadSize;
        this.queueSize = queueSize;
        this.threadKeepAlive = threadKeepAlive;
    }

    public long getIdle() {
        return idle;
    }

    public void setIdle(long idle) {
        this.idle = idle;
    }

    public int getCoreThreadSize() {
        return coreThreadSize;
    }

    public void setCoreThreadSize(int coreThreadSize) {
        this.coreThreadSize = coreThreadSize;
    }

    public int getMaxThreadSize() {
        return maxThreadSize;
    }

    public void setMaxThreadSize(int maxThreadSize) {
        this.maxThreadSize = maxThreadSize;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public long getThreadKeepAlive() {
        return threadKeepAlive;
    }

    public void setThreadKeepAlive(long threadKeepAlive) {
        this.threadKeepAlive = threadKeepAlive;
    }
}
