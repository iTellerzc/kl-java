package com.iteller.kl.netty.transport.codec.encode;

import com.iteller.kl.netty.dto.base.ReqTransport;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 11:21
 * description:通信编码
 */
public class TransportEncoder extends MessageToByteEncoder<ReqTransport> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ReqTransport nettyReq, ByteBuf byteBuf) throws Exception {

    }
}
