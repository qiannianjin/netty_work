package com.yinghu.yinghu.nettyIo;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author
 * @describetion ${}
 * @date 2020-8-22
 */

public class MyNetty {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        // BufferedReader bufferedReader=new BufferedReader();
//        Channel channel = new ServerSocketChannel();
//        Channel channel1= new SocketChannel();







    }
}
