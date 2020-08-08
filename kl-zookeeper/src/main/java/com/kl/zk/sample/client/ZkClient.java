package com.kl.zk.sample.client;

import com.kl.zk.sample.common.LifeCycle;
import com.kl.zk.sample.config.ZkClientConfig;

/**
 * @author iTeller_zc (zhangchao@elextec.com)
 * @date 2020/8/4 16:11
 * description
 **/
public abstract class ZkClient implements LifeCycle {

    private ZkClientConfig zkClientConfig;

}
