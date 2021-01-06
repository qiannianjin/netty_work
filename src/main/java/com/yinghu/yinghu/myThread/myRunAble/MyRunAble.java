package com.yinghu.yinghu.myThread.myRunAble;

public class MyRunAble implements Runnable{

    @Override
    public void run() {
        System.out.println("xixixi");
    }

    public static void main(String[] args) {

        Runnable runnable=new MyRunAble();
        Thread thread=new Thread(runnable);
        thread.start();
        thread.run();


    }





}
