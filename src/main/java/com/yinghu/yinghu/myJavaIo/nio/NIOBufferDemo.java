package com.yinghu.yinghu.myJavaIo.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NIOBufferDemo
 * @Description TODO
 * @Author whz
 * @Date 2023/5/31 16:51
 * Version 1.0
 **/
public class NIOBufferDemo {
    public static void main(String[] args) throws IOException {
        int bufferSize =1024;
        FileChannel src  = new FileInputStream("D:\\source.txt").getChannel();
        FileChannel dest = new FileOutputStream("D:\\dest.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        //通过chanel逐行读取写进去buffer;
        while (src.read(buffer)!=-1){
            //将缓存的读模式，切换成写模式
            buffer.flip();
            //由缓存血的刀chanel
            dest.write(buffer);
            //清空缓存，方便续写。
            buffer.clear();
        }

    }
}
