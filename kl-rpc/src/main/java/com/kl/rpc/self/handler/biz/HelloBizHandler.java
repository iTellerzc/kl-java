package com.kl.rpc.self.handler.biz;

import com.kl.common.utils.JSONUtil;
import com.kl.rpc.self.dto.base.ReqTransport;
import com.kl.rpc.self.dto.base.RespTransport;
import com.kl.rpc.self.dto.biz.HelloReq;
import com.kl.rpc.self.dto.biz.HelloResp;
import com.kl.rpc.self.handler.BizHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 20:11
 * description:
 */
public class HelloBizHandler implements BizHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloBizHandler.class);

    @Override
    public RespTransport bizHandle(ReqTransport nettyReq) {
        HelloReq helloReq = (HelloReq) nettyReq.getReq();
        LOGGER.info("hello req:{}.", JSONUtil.toStr(helloReq));
        HelloResp helloResp = new HelloResp("hello resp!");
        RespTransport nettyResp = null;
        return nettyResp;
    }
}
