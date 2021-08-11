package com.yinghu.yinghu.myThread;


import org.openjdk.jol.info.ClassLayout;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;

public class TestOne {

    public TestOne() throws IOException {
    }

    public static void main(String[] args) throws Exception{


//        Object o = new Object();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        //减法计数器
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int bb=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"还剩"+bb);
                countDownLatch.countDown();
            },String.valueOf(i)).start();

//            countDownLatch.await();
//            System.out.println("减完了"+bb);

        }
        countDownLatch.await();
        System.out.println("减完了");



    }

        public void test(){
            Thread thread=new MyThreadOne1();
            Thread thread1=new Thread(thread);
            for (int i = 0; i < 30; i++) {

                thread1.start();


            }


        }

        Collection collection;

        AbstractQueue abstractQueue =new AbstractQueue() {
            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean offer(Object o) {
                return false;
            }

            @Override
            public Object poll() {
                return null;
            }

            @Override
            public Object peek() {
                return null;
            }
        };

        URL url=new URL("127.0.0.1");
        HttpURLConnection http=(HttpURLConnection) url.openConnection();



//        PreparedStatement




        ServletRequestAttributes attributes;
        HttpServletRequest httpServletRequest=attributes.getRequest();

        Socket socket=new Socket();



}

class MyThreadOne1 extends Thread{


    @Override
    public void run() {

        //    System.out.println("hello");

        sendMessage();
        call();

        //super.run();
    }

    public synchronized void sendMessage(){

        System.out.println("发短信");

    }

    public synchronized void call(){
        System.out.println("打电话");
    }



}

