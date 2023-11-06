package com.yinghu.yinghu.mianshi.juc;

import com.yinghu.yinghu.myThread.ThreadTest.Synchronized;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Jmh
 * @Description TODO
 * @Author whz
 * @Date 2023/6/30 11:32
 * Version 1.0
 **/
public class Jmh {


    //public static void main(String[] args) {


       //AtomicInteger number = new AtomicInteger(0);
       //
       // Thread thread = new Thread(new Runnable() {
       //     synchronized
       //     @Override
       //     public void run() {
       //         //AtomicInteger numberA =number;
       //         while (number.intValue()<=100){
       //             System.out.println("a");
       //             number.incrementAndGet();
       //         }
       //     }
       // },"A");
       //

    //}


    private int times;
    private volatile boolean printA = true;

    public static void main(String[] args) {
        Jmh print = new Jmh();
        new Thread(() -> print.print("a", 100)).start();
        new Thread(() -> print.print("b", 100)).start();
    }

    public synchronized void print(String str, int total) {
        for (int i = 0; i < total; i++) {
            while (!(printA && str.equals("a") || !printA && str.equals("b"))) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            System.out.print(str);
            printA = !printA;
            notifyAll();
        }
    }






}







