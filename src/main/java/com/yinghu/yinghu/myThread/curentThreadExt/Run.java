package com.yinghu.yinghu.myThread.curentThreadExt;

public class Run {


    public static void main(String[] args) throws InterruptedException {
        CountOperate countOperate =new CountOperate();
        Thread thread=new Thread(countOperate);
        thread.setName("A");
        thread.start();



        Thread.sleep(1000);
        System.out.println("111111111"+Thread.currentThread().getName());


    }

}
