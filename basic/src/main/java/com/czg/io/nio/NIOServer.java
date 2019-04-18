package com.czg.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author chenzg
 * @date 2019.04.09 11:26
 * @description
 **/
public class NIOServer {

    private int port = 8000;
    private InetSocketAddress address = null;
    // 注册客户端连接信息
    private Selector selector;

    public NIOServer(int port) {
        try {
            this.port = port;
            address = new InetSocketAddress(this.port);
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(address);
            // 服务器通道设置为非阻塞的模式
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器启动：" + this.port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Selector开始轮询
     */
    public void listen() {
        try {
            //轮询
            while (true) {
                //在Selector上连接的数量
                int wait = this.selector.select();  //类似accept()是阻塞的
                if (wait == 0) continue;
                Set<SelectionKey> keys = this.selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    //针对每一个客户端进行相应的操作
                    process(key);
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理每一个客户端的请求
     */
    public void process(SelectionKey key) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        if (key.isAcceptable()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            // 客户端一旦连接上来，进行读写操作
            // 往这个Selector上注册Key，OP_READ，接下来可以进行读操作
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            int len = socketChannel.read(buffer);
            if (len > 0) {
                buffer.flip();
                String content = new String(buffer.array(), 0, len);
                System.out.println(content);
                socketChannel.register(selector, SelectionKey.OP_WRITE);
            }
            buffer.clear();
        } else if (key.isWritable()) {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            socketChannel.write(ByteBuffer.wrap("hello nio".getBytes()));
            socketChannel.close();
        }
    }

    public static void main(String[] args) {
        new NIOServer(8000).listen();
    }
}
