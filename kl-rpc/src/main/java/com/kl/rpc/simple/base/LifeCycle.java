package com.kl.rpc.simple.base;

import com.kl.rpc.simple.exception.LifyCycleException;

/**
 * @author iTeller_zc (000601)
 * @date 2020/8/8 9:25
 * description:
 **/
public interface LifeCycle {

    /**
     * 启动
     */
    void start() throws LifyCycleException;

    /**
     * shutdown
     */
    void stop() throws LifyCycleException;
}
