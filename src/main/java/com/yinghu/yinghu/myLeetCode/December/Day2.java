package com.yinghu.yinghu.myLeetCode.December;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.WebSocketContainer;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;

public class Day2 {


    List myList=new ArrayList();

    TreeMap treeMap=new TreeMap();

    //Class
    public static void main(String[] args) throws Exception{

        Object object=new Object();
        object.hashCode();
        String s="111";
        Integer aa;
        HashSet hashSet=new HashSet();
        Vector vector=new Vector();

        File file = new File("user.ser");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        User user = new User("zhang", 18, Gender.MALE);
        oout.writeObject(user);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newUser = oin.readObject();
        oin.close();
        System.out.println(newUser);

//        HttpServlet httpServlet=new HttpServlet()
////        {
//            //这是默认实现它的静态方法吗？
////            @Override
////            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////                super.doGet(req, resp);
////            }
//
////        }
//        ;

        // TODO 自动生成的方法存根

        String readline = null;
        String inTemp = null;
        //String outTemp = null;
        String turnLine = "\n";
        final String client = "Client:";
        final String server = "Server:";

        int port = 4000;
        byte ipAddressTemp[] = {127, 0, 0, 1};
        InetAddress ipAddress = InetAddress.getByAddress(ipAddressTemp);

        //首先直接创建socket,端口号1~1023为系统保存，一般设在1023之外
        Socket socket = new Socket(ipAddress, port);

        //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

        while(readline != "bye"){

            System.out.println(client);
            readline = systemIn.readLine();
            //System.out.println(readline);

            socketOut.println(readline);
            socketOut.flush();    //赶快刷新使Server收到，也可以换成socketOut.println(readline, ture)

            //outTemp = readline;
            inTemp = socketIn.readLine();

            //System.out.println(client + outTemp);
            System.out.println(server + turnLine + inTemp);

        }

        systemIn.close();
        socketIn.close();
        socketOut.close();
        socket.close();



        Thread thread=new Thread();

        System system;


    }

    Serializable serializable;




    //一句话总结到底，java的全部功能都是有java的本地接口方法来实现的
    //通过native关键字来映射和匹配jdk的预先写好的c或C++的文件


}
