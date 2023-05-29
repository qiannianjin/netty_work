package com.yinghu.yinghu.mynetty.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @ClassName ChatHandler
 * @Description TODO
 * @Author whz
 * @Date 2023/5/21 0:49
 * Version 1.0
 **/
class ChatHandler implements Runnable {
    private Socket socket;
    private ArrayList<PrintWriter> writers = new ArrayList<>();

    public ChatHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 获取输入输出流
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // 发送先前的消息
            for (PrintWriter writer : writers) {
                writer.println(in.readLine());
            }
            // 将新客户端添加到广播列表
            writers.add(out);
            // 聊天循环
            while (true) {
                // 读取客户端消息并转发给所有客户端
                String msg = in.readLine();
                if (msg == null) {
                    break;
                }
                System.out.println(msg);
                for (PrintWriter writer : writers) {
                    writer.println(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}