package com.kl.zk.sample.config;

import com.kl.zk.sample.address.RemoteAddress;

/**
 * @author iTeller_zc (zhangchao@elextec.com)
 * @date 2020/8/4 16:12
 * description
 **/
public class ZkClientConfig {

    private RemoteAddress remoteAddress;

    public ZkClientConfig(){

    }

    public ZkClientConfig(RemoteAddress remoteAddress){
        this.remoteAddress = remoteAddress;
    }

    public RemoteAddress getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(RemoteAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}
