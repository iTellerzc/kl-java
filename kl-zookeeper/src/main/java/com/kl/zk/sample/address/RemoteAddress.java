package com.kl.zk.sample.address;

import lombok.Data;

/**
 * @author iTeller_zc (zhangchao@elextec.com)
 * @date 2020/8/4 15:23
 * description zk server address
 **/
@Data
public class RemoteAddress {

    private String address;

    private int host;
}
