package com.czg.io.bio;

/**
 * @author chenzg
 * @date 2019.04.09 11:23
 * @description
 **/
import java.io .IOException;
import java.io .InputStream;
import java.io .OutputStream;
import java.net.Socket;

public class ServerHandler implements Runnable {

    //维护一个socket成员变量，记录传来的socket
    private Socket socket;
    public ServerHandler (Socket socket) {
        this.socket = socket;
    }

    //当前线程要执行的任务
    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            //读取客户端的数据
            while ((length = inputStream.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, length));
            }
            //向客户端写数据
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello java".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
