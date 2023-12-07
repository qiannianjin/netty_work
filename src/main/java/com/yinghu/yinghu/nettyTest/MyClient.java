package com.yinghu.yinghu.nettyTest;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName MyClient
 * @Description TODO
 * @Author whz
 * @Date 2023/11/15 21:12
 * Version 1.0
 **/
public class MyClient {

    public static void main(String[] args) throws Exception {

        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9001);
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(socketAddress);
        Selector open = Selector.open();
        Scanner scanner = new Scanner(System.in);
        socketChannel.register(open, SelectionKey.OP_CONNECT);

        while (true) {

            open.select();

            Set<SelectionKey> selectionKeys = open.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            //要记得事件删除
            while (iterator.hasNext()) {

                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isConnectable()) {

                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                        System.out.println("已经连接到");
                    }

                    channel.register(open, SelectionKey.OP_READ);

                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int read = socketChannel1.read(byteBuffer);
                    if (read > 0) {
                        byteBuffer.flip();
                        System.out.println("收到消息:" + new String(byteBuffer.array(), 0, read));
                    }

                }
                // 处理控制台输入并发送给服务器
                if (scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    channel.write(ByteBuffer.wrap(message.getBytes()));
                }

                iterator.remove();
            }





        }

    }


}
