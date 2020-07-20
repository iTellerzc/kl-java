package com.iteller.kl.rpc.self.buffer;

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
        System.out.println(byteBuf.writerIndex());
        System.out.println(byteBuf.readerIndex());
    }


    @Test
    public void testReaderIndex(){
        ByteBuf byteBuf = Unpooled.buffer(8);
        byteBuf.readerIndex(2);//exception  readerIndex <= writerIndex
    }

    @Test
    public void testWriterIndex(){
        ByteBuf byteBuf = Unpooled.buffer(8);
        System.out.println(byteBuf.readerIndex());
        byteBuf.writerIndex(4);
        System.out.println(byteBuf.writerIndex());
    }

    @Test
    public void testReadableBytes(){
        ByteBuf byteBuf = Unpooled.buffer(8);
        System.out.println(byteBuf.readableBytes());//writerIndex-readerIndex
    }

    @Test
    public void testWritableBytes(){
        ByteBuf byteBuf = Unpooled.buffer(8);
        System.out.println(byteBuf.writableBytes());//capacity-writerIndex
    }

    /**
     * Discards the bytes between the 0th index and {@code readerIndex}.
     * It moves the bytes between {@code readerIndex} and {@code writerIndex}
     * to the 0th index, and sets {@code readerIndex} and {@code writerIndex}
     * to {@code 0} and {@code oldWriterIndex - oldReaderIndex} respectively.
     * <p>
     * Please refer to the class documentation for more detailed explanation.
     */
    @Test
    public void testDiscardBytes(){
        ByteBuf byteBuf = Unpooled.buffer(8);
        byteBuf.writeInt(1);
        byteBuf.writeByte(2);
        byteBuf.writeChar(97);
        System.out.println(byteBuf.readInt());
        System.out.println(byteBuf.readByte());
        System.out.println(byteBuf.readChar());
        System.out.println(byteBuf.readerIndex());
        System.out.println(byteBuf.writerIndex());
        System.out.println(byteBuf.discardReadBytes());
        System.out.println(byteBuf.readerIndex());
        System.out.println(byteBuf.writerIndex());
    }

}
