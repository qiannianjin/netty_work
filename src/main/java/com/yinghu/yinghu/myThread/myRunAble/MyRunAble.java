package com.yinghu.yinghu.myThread.myRunAble;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.Buffer;

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
        Reader in;
        InputStream in1=System.in;
       // BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in1));

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in1));



    }





}
