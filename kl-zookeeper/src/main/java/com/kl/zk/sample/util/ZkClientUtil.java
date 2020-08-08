package com.kl.zk.sample.util;

import com.kl.zk.sample.client.ZkClient;
import com.kl.zk.sample.config.ZkClientConfig;
import com.kl.zk.sample.factory.ZkClientFactory;

/**
 * @author iTeller_zc (zhangchao@elextec.com)
 * @date 2020/8/4 15:26
 * description
 **/
public class ZkClientUtil {

    public static ZkClient fetch(ZkClientConfig zkClientConfig){
        return ZkClientFactory.create(zkClientConfig);
    }
}
