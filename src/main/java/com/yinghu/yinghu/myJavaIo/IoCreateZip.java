package com.yinghu.yinghu.myJavaIo;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName IoCreateZip
 * @Description TODO
 * @Author whz
 * @Date 2023/5/30 17:02
 * Version 1.0
 **/
public class IoCreateZip {
    public static void main(String[] args) {
        String zipFile = "D:\\redirect.zip";
        String file1 = "D:\\redirect.txt";
        int zipRes = -1;
        FileOutputStream fout =null;
        ZipOutputStream zout = null;
        BufferedOutputStream bout = null;
        FileInputStream fisOne = null;
        BufferedInputStream bisOne = null;

        try{
             //压缩文件输出流
             fout = new FileOutputStream(zipFile);
             zout = new ZipOutputStream(fout);
             bout = new BufferedOutputStream(zout);
             //压缩文件按输入流
             fisOne = new FileInputStream(file1);
             bisOne = new BufferedInputStream(fisOne);


             //逐行将缓存流中的数据放入，输出流中，这个时候还没压缩。
             while ((zipRes = bisOne.read())!=-1){
                 bout.write(zipRes);
             }
            //设置输出流的格式，是压缩格式
            zout.putNextEntry(new ZipEntry("redirect.txt"));
             //强制输出
            bout.flush();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                bisOne.close();
                fout.close();
                zout.close();
                fisOne.close();
                bout.close();

            }catch (IOException e){
                e.printStackTrace();
            }
        }




    }
}
