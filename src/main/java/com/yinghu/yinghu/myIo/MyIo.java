package com.yinghu.yinghu.myIo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Classname MyIo
 * @Description 实现逐行文件读取
 *
 * @Date 2021/2/6 21:33
 * @Created by whz
 */
public class MyIo  {



 //逐行读取，逐行写入
 public void myIo() {

     FileReader reader =null;
     BufferedReader bufferedReader =null;

     try{
         //先从本地文件读取数据流到内存
         //然后再从内存中写入到本地
         //
         reader = new FileReader("e://d/from.txt");
         bufferedReader = new BufferedReader(reader);
         String line =null;

         while(true){
             line =bufferedReader.readLine();
             if(line ==null){
                 break;
             }
             System.out.println(line);
         }

     }catch(Exception e){
         System.out.println(e);
     }

     finally{
         try{
             bufferedReader.close();
             reader.close();

         }catch(Exception e){
             System.out.println(e);
         }
     }
 }


    public void myTest(){

     HashMap hashMap = new HashMap();




    }









}






