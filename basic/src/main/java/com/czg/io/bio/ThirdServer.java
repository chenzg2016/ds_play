package com.czg.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenzg
 * @date 2019.04.09 11:25
 * @description
 **/
public class ThirdServer {
    public static void main (String[] args) {
        ServerSocket serverSocket;
        ExecutorService executorService = Executors.newFixedThreadPool(60);
        try {
            serverSocket = new ServerSocket(8000);
            System.out.println("服务器启动成功，监听端口8000");
            while (true) {
                Socket socket = serverSocket.accept();
                //使用线程池中的线程去执行每个对应的任务
                executorService.execute(new ServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
