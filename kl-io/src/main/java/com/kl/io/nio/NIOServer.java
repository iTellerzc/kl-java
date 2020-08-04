package com.kl.io.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/21 17:32
 * description:
 */
public class NIOServer {

    private static final Logger logger = LoggerFactory.getLogger(NIOServer.class);

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        serverSocketChannel.configureBlocking(false);
        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null){
                logger.info("没有链接");
                continue;
            }

            logger.info("新链接,端口:{}.", ((InetSocketAddress)socketChannel.getRemoteAddress()).getPort());
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            socketChannel.read(byteBuffer);
            logger.info("接收数据.");
        }
    }
}
