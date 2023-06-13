package com.yinghu.yinghu.myJavaIo;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @ClassName IoRedirectOutput
 * @Description TODO
 * @Author whz
 * @Date 2023/5/30 16:03
 * Version 1.0
 **/
public class IoRedirectOutput {
            //输出重定向
    public static void main(String[] args) {

        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        PrintStream ps = null;
        try{
            new FileOutputStream("D:\\redirect.txt");
            bout = new BufferedOutputStream(fout);

            //固定的流
            ps = new PrintStream(bout);
            //这里是输出重定向，有原来的输出到控制台（sout），变成ps(输出到文件)
            System.setOut(ps);
            System.out.println("redirect to redirct.txt");
            ps.flush();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
                ps.close();
        }



    }

}
