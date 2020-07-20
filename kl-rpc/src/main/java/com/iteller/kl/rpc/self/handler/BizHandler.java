package com.iteller.kl.rpc.self.handler;

import com.iteller.kl.rpc.self.dto.base.ReqTransport;
import com.iteller.kl.rpc.self.dto.base.RespTransport;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:19
 * description:
 */
public interface BizHandler {

    RespTransport bizHandle(ReqTransport nettyReq);
}
