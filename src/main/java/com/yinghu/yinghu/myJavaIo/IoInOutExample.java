package com.yinghu.yinghu.myJavaIo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName IoInOutExample
 * @Description TODO
 * @Author whz
 * @Date 2023/5/29 23:35
 * Version 1.0
 **/
public class IoInOutExample {

    public static void main(String[] args) {

        //从键盘中获取流，并且将流输入到缓冲区
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = null;
        System.out.print("input is : ");
        try{
            //
             read = br.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("outPut is : " + read);
    }

}
