package com.yinghu.yinghu.mynetty.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName ChatServer
 * @Description TODO
 * @Author whz
 * @Date 2023/5/21 0:50
 * Version 1.0
 **/
public class ChatServer {
    private static final int PORT = 8000;

    public static void main(String[] args) throws IOException {
        // 监听指定端口
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            // 等待客户端连接
            Socket socket = serverSocket.accept();
            // 为每个客户端创建一个线程
            new Thread(new ChatHandler(socket)).start();
        }
    }
}
