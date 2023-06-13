package com.yinghu.yinghu.myJavaIo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @ClassName IOReadZip
 * @Description TODO
 * @Author whz
 * @Date 2023/5/31 16:28
 * Version 1.0
 **/
public class IOReadZip {

    public static void main(String[] args) {

        int cont;
        FileInputStream fin = null;
        ZipInputStream zin = null;
        ZipEntry ze = null;
        try{
            fin = new FileInputStream("D:\\redirect.zip");
            zin = new ZipInputStream(new BufferedInputStream(fin));
            //getNextEntry,是为了获取文件，一个压缩包里面可能有个几个文件，所以用了双重循环。
            while ((ze = zin.getNextEntry())!=null){
                System.out.println("fileName is "+ ze);
                while ((cont = zin.read())!=-1){
                    //这里可以不用输出，或者放入的一个bufferStream--》fileStream--》强行flush（）就可以了
                    System.out.println(cont);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
