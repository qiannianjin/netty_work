package com.yinghu.yinghu.myJavaIo;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName IoRedirectInput
 * @Description TODO
 * @Author whz
 * @Date 2023/5/30 16:41
 * Version 1.0
 **/
public class IoRedirectInput {

    //输入重定向
    public static void main(String[] args) {
        BufferedInputStream bin = null;
        DataInputStream ds = null;
        try{
            String tmp;
            bin = new BufferedInputStream(new FileInputStream(""));
            //将系统的默认输出编程了，自定义的输入，
            System.setIn(bin);
            //然后这个System.in就是我们自定义的文件输入流，而不是键盘输入（默认的）
            ds = new DataInputStream(System.in);
            while ((tmp = ds.readLine())!=null){
                System.out.println(tmp);
            }
        }catch (IOException e){
            e.printStackTrace();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
    try{
        bin.close();
    }catch (IOException e){
        e.printStackTrace();
    }
    try {
        ds.close();
    } catch (IOException e) {
        e.printStackTrace();
    }


        }

    }
}
