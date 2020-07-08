package com.iteller.kl.netty.handler;

import com.iteller.kl.netty.dto.base.NettyReq;
import com.iteller.kl.netty.dto.base.NettyResp;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:19
 * description:
 */
public interface BizHandler {

    NettyResp bizHandle(NettyReq nettyReq);
}
