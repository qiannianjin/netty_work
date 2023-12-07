package com.yinghu.yinghu.myThread.threadpool;

/**
 * @ClassName TestingThread
 * @Description TODO
 * @Author whz
 * @Date 2023/11/14 15:40
 * Version 1.0
 **/
public class TestingThread {

    public static void main(String[] args) {

        while(true){
            System.out.println("外层循环");

            while (true){
                System.out.println("内层循环");
            }
        }


    }






}
