package com.yinghu.yinghu.nettyTest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @ClassName JavaNioServer
 * @Description TODO
 * @Author whz
 * @Date 2023/5/25 0:13
 * Version 1.0
 **/
public class JavaOioServer {
    //oio是阻塞，onblocking
    //nio是非阻塞，noblocking



    //一直在循环，来一个处理一个，但是进入下一次循环回阻塞，原因是先处理本次请求。
    public static void main(String[] args) throws IOException {
        int port = 9000;
        ServerSocket serverSocket = new ServerSocket(9000);
        for(;;){
           final Socket accept = serverSocket.accept();
            System.out.println("接收到连接"+accept);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    OutputStream outputStream;
                    try {
                        outputStream = accept.getOutputStream();
                        outputStream.write("Hi\r\n".getBytes(Charset.forName("UTF-8")));
                        outputStream.flush(); //将缓冲区的数据立刻输出到控制台，而不是等程序结束子厚输出
                        accept.close();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }finally {
                        try {
                            accept.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }


                }
            }).start();




        }





    }




}
