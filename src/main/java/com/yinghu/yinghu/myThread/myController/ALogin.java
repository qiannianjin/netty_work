package com.yinghu.yinghu.myThread.myController;

public class ALogin extends Thread{
    @Override
    public void run(){
        LoginServlet.doPost("a","aa");

    }


}
