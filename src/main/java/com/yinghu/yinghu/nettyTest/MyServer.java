package com.yinghu.yinghu.nettyTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName MyServer
 * @Description TODO
 * @Author whz
 * @Date 2023/11/15 21:12
 * Version 1.0
 **/
public class MyServer {

    public static void server1(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);


        int OP_ACCEPT = 1 << 4;
        System.out.println(OP_ACCEPT);

        // 创建NIO ServerSocketChannel
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9001));
        // 设置ServerSocketChannel为非阻塞
        serverSocket.configureBlocking(false);
        // 打开Selector处理Channel，即创建epoll
        Selector selector = Selector.open();
        // 把ServerSocketChannel注册到selector上，并且selector对客户端accept连接操作感兴趣
        SelectionKey selectionKey = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务启动成功");

        while (true) {
            // 阻塞等待需要处理的事件发生 已注册事件发生后，会执行后面逻辑
            selector.select();

            // 获取selector中注册的全部事件的 SelectionKey 实例
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            // 遍历SelectionKey对事件进行处理
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 如果是OP_ACCEPT事件，则进行连接获取和事件注册
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    // 这里只注册了读事件，如果需要给客户端发送数据可以注册写事件
                    SelectionKey selKey = socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("客户端连接成功");
                } else if (key.isReadable()) {  // 如果是OP_READ事件，则进行读取和打印
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int len = socketChannel.read(byteBuffer);
                    // 如果有数据，把数据打印出来
                    if (len > 0) {
                        System.out.println(Thread.currentThread().getName() + "接收到消息：" + new String(byteBuffer.array()));
                    } else if (len == -1) { // 如果客户端断开连接，关闭Socket
                        System.out.println("客户端断开连接");
                        socketChannel.close();
                    }
                }

                //从事件集合里删除本次处理的key，防止下次select重复处理
                iterator.remove();
            }
        }
    }

    public static void server2(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9001));
        serverSocket.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务启动成功");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    System.out.println("客户端连接成功");
                } else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int len = socketChannel.read(byteBuffer);

                    if (len > 0) {
                        byteBuffer.flip();
                        System.out.println("接收到消息：" + new String(byteBuffer.array(), 0, len));
                    } else if (len == -1) {
                        System.out.println("客户端断开连接");
                        socketChannel.close();
                    }

                    // 注册写事件，以便向客户端发送消息
                    socketChannel.register(selector, SelectionKey.OP_WRITE);
                } else if (key.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    System.out.print("请输入要发送的消息: ");
                    if (scanner.hasNextLine()) {
                        String message = scanner.nextLine();
                        socketChannel.write(ByteBuffer.wrap(message.getBytes()));
                    }


                    // 注册读事件，以便继续接收客户端的消息
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }

                iterator.remove();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        server2(null);
    }

}
