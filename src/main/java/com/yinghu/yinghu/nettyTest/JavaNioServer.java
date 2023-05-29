package com.yinghu.yinghu.nettyTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName JavaNioServer
 * @Description TODO
 * @Author whz
 * @Date 2023/5/25 8:52
 * Version 1.0
 **/
public class JavaNioServer {
     //前置知识，首先是配置

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket socket = serverSocketChannel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(9000);
        socket.bind(inetSocketAddress);
        Selector selector = Selector.open();
        //将socketChannel注册到选择器，选择器其实就是一个轮询
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        final ByteBuffer msg = ByteBuffer.wrap("Hi\r\n".getBytes());
        for(;;){
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                try{
                    if (key.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel)key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector,SelectionKey.OP_WRITE|SelectionKey.OP_READ,msg.duplicate());
                        System.out.println("accept connetion from" + client);
                        if (key.isWritable()){
                            client = (SocketChannel) key.channel();
                            ByteBuffer buffer = (ByteBuffer)key.attachment();
                            while (buffer.hasRemaining()){
                                if(client.write(buffer) ==0){
                                    break;
                                }
                            }
                        client.close();

                        }

                    }
                }catch (IOException ex){
                    key.cancel();
                    try {
                        key.channel().close();
                    }catch (IOException cex){

                    }
                }

            }

        }

    }

}
