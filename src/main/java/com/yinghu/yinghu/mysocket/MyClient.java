package com.yinghu.yinghu.mysocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyClient {

    public static void main(String[] args) throws Exception{

        Socket socket =new Socket(InetAddress.getLocalHost().getHostAddress(),8888);

        OutputStream outputStream=socket.getOutputStream();

        DataOutputStream dataOutputStream=new DataOutputStream(outputStream);

        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());

        dataOutputStream.writeUTF("草泥马");

    //    ForkJoinPool forkJoinPool=new ForkJoinPool();

            Lock lock=new ReentrantLock();
            Condition condition=lock.newCondition();

            Callable callable=new Callable() {
                @Override
                public Object call() throws Exception {
                    return null;
                }
            };
            FutureTask futureTask=new FutureTask<>(callable);









        Scanner in =new Scanner(System.in);

        while(in.next()!="00"){

            in=new Scanner(System.in);

            dataOutputStream.writeUTF(in.next());

            System.out.println(dataInputStream.readUTF());

           // System.out.println(dataInputStream.readUTF());

        }

        dataOutputStream.close();

    }



class Testmy{

        //类或接口的定义， 不能用变量作为传参进去？



        public String hello() throws BrokenBarrierException, InterruptedException {
            int k=10;
            for (int i =0; i <10 ; i++) {
                int b=0;
                new Thread(()->{

                    System.out.println(k);

                    },Integer.toString(i)).start();

            }
            //减法计数器
            CountDownLatch countDownLatch = new CountDownLatch(10);
            for (int i = 0; i < 10; i++) {
                    int bb=i;
                new Thread(()->{
                    System.out.println(Thread.currentThread().getName()+"还剩"+bb);
                    countDownLatch.countDown();
                    },String.valueOf(i)).start();

            }
            countDownLatch.await();
            System.out.println("减完了");



            //加法计数器
            CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
                System.out.println("完成");
            });

            int await = cyclicBarrier.await();


            Semaphore semaphore = new Semaphore(5);
            for (int i = 0; i < 10; i++) {

//                semaphore.acquire();
                new Thread(()->{
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"抢到车位");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println(Thread.currentThread().getName()+"离开车位");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                    //String.valueOf(i);
                },Integer.toString(i)).start();
            }

            return "hello";
        }







}





}
