package com.yinghu.yinghu.nettyTest;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName MyClient2
 * @Description TODO
 * @Author whz
 * @Date 2023/11/20 22:30
 * Version 1.0
 **/
public class MyClient2 {

    public static void main(String[] args) throws Exception {

        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9001);
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        while (true) {
            try {
                socketChannel.connect(socketAddress);
                System.out.println("连接成功");
                break;  // 连接成功，退出循环
            } catch (ConnectionPendingException e) {
                // 连接尚在进行中，可以处理其他事务
                System.out.println("连接尚在进行中，可以处理其他事务");
            } catch (ClosedChannelException e) {
                // 连接已关闭，可以处理其他事务
                System.out.println("连接已关闭，可以处理其他事务");

            } catch (Exception e){
                System.out.println("连接失败，可以处理其他事务");
            }
            // 等待一段时间再重试
            Thread.sleep(1000);
        }


        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT|SelectionKey.OP_READ|SelectionKey.OP_WRITE);
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
