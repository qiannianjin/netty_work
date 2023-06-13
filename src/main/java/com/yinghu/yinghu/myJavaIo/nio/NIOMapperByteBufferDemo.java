package com.yinghu.yinghu.myJavaIo.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NIOMapperByteBufferDemo
 * @Description TODO
 * @Author whz
 * @Date 2023/5/31 17:24
 * Version 1.0
 **/
public class NIOMapperByteBufferDemo {
    public static void main(String[] args) throws IOException {

        int length = 1024 * 1024 * 10;
        //将文件与out对象绑定（map）
        MappedByteBuffer out = new RandomAccessFile("D:\\bigFile.txt", "rw")
                .getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);//设置文件的模式为读写，起始位置，长度
        //写文件，写一些文件字节进去out里面。
        for (int i = 0; i < length; i++) {
            out.put((byte) 'a');
        }

        //读文件，从out中读出啦
        for (int i = 0; i < 10; i++) {
            System.out.println((char) out.get(i));
        }


    }
}
