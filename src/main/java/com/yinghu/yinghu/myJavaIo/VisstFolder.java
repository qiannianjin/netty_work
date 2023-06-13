package com.yinghu.yinghu.myJavaIo;

import java.io.File;

/**
 * @ClassName VisstFolder
 * @Description TODO
 * @Author whz
 * @Date 2023/5/29 23:05
 * Version 1.0
 **/
public class VisstFolder {

    //循循环遍历文件夹，找出csv结尾的文件

    static void getCSVFolder(String filePath){

        File folderName = new File(filePath);
        File[] flist = folderName.listFiles();
        if (flist == null || flist.length ==0) {
            return;
        }
        String fileName = null;
        for(File f: flist){
            if ( f.isDirectory()) {
                getCSVFolder(f.getAbsolutePath());
            }else {
                 fileName = f.getName();
                 if(fileName.substring(fileName.lastIndexOf(".")+1).equals("csv")){
                     System.out.println(f.getAbsolutePath());
                 }


            }
        }


    }

    public static void main(String[] args) {
        getCSVFolder("D://test");
    }


}
