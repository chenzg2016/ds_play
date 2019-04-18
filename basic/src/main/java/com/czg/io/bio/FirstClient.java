package com.czg.io.bio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 * @author chenzg
 * @date 2019.04.09 10:31
 * @description
 **/
public class FirstClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello world".getBytes());
            outputStream.flush();
            byte[] buffer = new byte[1024];

            // 读取服务端的数据
            InputStream inputStream = socket.getInputStream();
            int length = 0;
            while ((length = inputStream.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, length));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
