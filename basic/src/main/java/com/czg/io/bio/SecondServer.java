package com.czg.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenzg
 * @date 2019.04.09 11:24
 * @description
 **/
public class SecondServer {

    public static void main (String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
            System.out.println("服务器启动成功，监听端口8000");
            while (true) {
                Socket socket = serverSocket.accept();
                // 针对每个连接创建一个线程，去处理IO操作
                new Thread(new ServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
