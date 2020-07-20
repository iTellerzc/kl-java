package com.iteller.kl.rpc.self.convert;

import com.iteller.kl.rpc.self.consts.TransportDirections;
import com.iteller.kl.rpc.self.dto.base.TransportHeader;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 9:41
 * description:
 */
public class TransportConvert {

    /**
     * 输出转换
     * @param transportHeader
     * @return
     */
    public TransportHeader convert2Resp(TransportHeader transportHeader){
        transportHeader.setType(TransportDirections.OUTPUT);
        return transportHeader;
    }
}
