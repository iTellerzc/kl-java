package com.iteller.kl.netty.convert;

import com.iteller.kl.netty.consts.TransportDirections;
import com.iteller.kl.netty.dto.base.NettyBaseHeader;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 9:41
 * description:
 */
public class TransportConvert {

    /**
     * 输出转换
     * @param nettyBaseHeader
     * @return
     */
    public NettyBaseHeader convert2Resp(NettyBaseHeader nettyBaseHeader){
        nettyBaseHeader.setType(TransportDirections.OUTPUT);
        return nettyBaseHeader;
    }
}
