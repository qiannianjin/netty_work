package com.yinghu.yinghu.myJavaIo;

import java.io.*;

/**
 * @ClassName CopyFile
 * @Description TODO
 * @Author whz
 * @Date 2023/5/29 23:20
 * Version 1.0
 **/
public class CopyFile {
    static void fileCopy(String src, String des) {

        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(src);
            output = new FileOutputStream(des);
            int fileLength = input.available();
            //创建缓冲区，根据文件长度
            byte[] buffer = new byte[fileLength];
            //将文本流，读进缓冲区
            input.read(buffer);
            //将缓冲区数据流输出到，文件
            output.write(buffer);


        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关掉输入流
            if(input !=null){
                try{
                    input.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            //关掉输出流
            if (output != null){
                try {
                    output.close();
                } catch (IOException e) {
                   e.printStackTrace();
                }
            }

        }


    }


    public static void main(String[] args) {
        fileCopy("","");
    }


}
