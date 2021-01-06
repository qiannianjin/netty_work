package com.yinghu.yinghu.myThread.curentThreadExt;

public class CountOperate extends Thread{

    public CountOperate(){

        System.out.println("countOperate--begin");
        System.out.println("Thread.currentThread.getName=="+Thread.currentThread().getName());
        System.out.println("this.getName()=="+this.getName());
        System.out.println("CountOperate--end");

    }
    @Override
    public void run(){
        System.out.println("run---begin");
        System.out.println("Thread.currentThread.getName()="+Thread.currentThread().getName());
        System.out.println("this.getName()"+this.getName());
        System.out.println("run--end");

    }



}
