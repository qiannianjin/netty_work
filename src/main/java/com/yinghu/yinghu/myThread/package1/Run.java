package com.yinghu.yinghu.myThread.package1;

public class Run {


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a=new Thread(myThread,"A");
        Thread b=new Thread(myThread,"B");
        Thread c=new Thread(myThread,"C");
        Thread d=new Thread(myThread,"D");
        Thread e=new Thread(myThread,"E");

        c.start();
        d.start();
        e.start();
        a.start();
        b.start();



    }
}
