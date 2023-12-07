package com.yinghu.yinghu.nettyTest;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName Myclient3
 * @Description TODO
 * @Author whz
 * @Date 2023/11/21 9:35
 * Version 1.0
 **/
public class Myclient3 {

    public static void main(String[] args) throws Exception{

            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9001);
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();

            socketChannel.connect(socketAddress);
            while(true) {
                try {
                   socketChannel.finishConnect();
                break;
                } catch (Exception e) {
                    System.out.println("连接失败,正在重试");
                    socketChannel.connect(socketAddress);
                }
                Thread.sleep(1000);

            }
            System.out.println("连接成功");

//            while (true) {
//                try {
//                    boolean connect = socketChannel.connect(socketAddress);
//                    boolean b = socketChannel.finishConnect();
//
//                    System.out.println("连接成功");
//                    break;  // 连接成功，退出循环
//                } catch (Exception e) {
//                    System.out.println("等待服务器响应");
//                }
//                // 等待一段时间再重试
//                Thread.sleep(1000);
//            }


//            System.out.println("连接成功");
            // 这里可以继续处理其他事务，例如发送消息等
//            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();

                    if (selectionKey.isConnectable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        if (channel.finishConnect()) {
                            System.out.println("已经连接到服务器");
                            channel.register(selector, SelectionKey.OP_READ);
                        }
                    } else if (selectionKey.isReadable()) {
                        SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int read = socketChannel1.read(byteBuffer);
                        if (read > 0) {
                            byteBuffer.flip();
                            System.out.println("收到消息:" + new String(byteBuffer.array(), 0, read));
                        }
                    }

                    iterator.remove();
                }

                // 处理控制台输入并发送给服务器
                if (scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    socketChannel.write(ByteBuffer.wrap(message.getBytes()));
                }
            }

    }
}