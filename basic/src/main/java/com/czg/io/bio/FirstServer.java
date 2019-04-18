package com.czg.io.bio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenzg
 * @date 2019.04.09 10:41
 * @description
 **/
public class FirstServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("服务器启动成功，监听端口8000");
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int length = 0;
                // 读取客户端的数据
                while ((length = inputStream.read(buffer)) > 0) {
                    System.out.println(new String(buffer, 0, length));
                }
                // 向客户端写数据
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("hello java".getBytes());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
