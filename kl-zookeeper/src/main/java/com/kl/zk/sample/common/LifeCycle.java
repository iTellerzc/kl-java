package com.kl.zk.sample.common;

/**
 * @author iTeller_zc (zhangchao@elextec.com)
 * @date 2020/8/4 16:09
 * description
 **/
public interface LifeCycle {

    /**
     * 初始化
     */
    void init();

    /**
     * 扫描
     */
    void scan();

    /**
     * 启动
     */
    void start();

    /**
     * 停止
     */
    void stop();
}
