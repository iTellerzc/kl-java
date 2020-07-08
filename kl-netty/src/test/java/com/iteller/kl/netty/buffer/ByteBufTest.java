package com.iteller.kl.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/8 15:26
 * description:
 */
public class ByteBufTest {

    @Test
    public void testByteBuf(){
        ByteBuf byteBuf = Unpooled.buffer(32);
        System.out.println(byteBuf.writableBytes());
        System.out.println(byteBuf.readableBytes());
        for(int i = 0; i < byteBuf.capacity(); i++){
            byte byteValue = byteBuf.getByte(i);
            System.out.println(byteValue);
        }
        System.out.println(byteBuf.capacity());
    }


}
