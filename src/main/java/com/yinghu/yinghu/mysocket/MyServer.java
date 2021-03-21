package com.yinghu.yinghu.mysocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.*;

public class MyServer {


    void test(){

        Future future;

        Callable<String> callable =new Callable() {
            @Override
            public String call() throws Exception {
                return "hello world";
            }
        };
        TimeUnit unit = null;
        //BlockingQueue workQueue=;

        //ThreadPoolExecutor service=new ThreadPoolExecutor(10, 10, 100, unit, workQueue);
        //常见的四种线程池



        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();


        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        executorService.submit(runnable);



    }




    public static void main(String[] args) throws IOException {
        System.out.println("启动监听");
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();


        //监听
        System.out.println("连接成功");
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        String s = dataInputStream.readUTF();
        Scanner in =new Scanner(System.in);

        while(in.next()!="00"){
            in =new Scanner(System.in);
            dataOutputStream.writeUTF(in.next());
            System.out.println(dataInputStream.readUTF());
        }




        System.out.println(s);
        dataInputStream.close();


    }

}
