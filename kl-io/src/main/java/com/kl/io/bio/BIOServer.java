package com.kl.io.bio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/21 15:49
 * description:
 */
public class BIOServer {

    private static final Logger logger = LoggerFactory.getLogger(BIOServer.class);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true){
            Socket socket = serverSocket.accept();
            logger.info("建链端口:{}", socket.getPort());
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            while ((str = reader.readLine()) != null){
                logger.info("接收请求:{}" , str);
                socket.getOutputStream().write("ok\n".getBytes());
                socket.getOutputStream().flush();
                if("over".equals(str)){
                    logger.info("断链!");
                    socket.close();
                    break;
                }
            }
            System.out.println("====");
        }
    }
}
