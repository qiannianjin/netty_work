package com.yinghu.yinghu.mynetty.myByteBuffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.apache.tomcat.util.http.fileupload.UploadContext;

/**
 * @author
 * @describetion ${}
 * @date 2020-10-12
 */
public class MyByteBuffTest {

//public static ByteBuf byteBuf(int initialCapacity, int maxCapacity){
//
//
//
//}


    public static void main(String[] args) {

//    ByteBuf byteBuf=new ByteBuf() {
//    }



        ByteBuf byteBuf= Unpooled.buffer();
        System.out.println(byteBuf.toString());

    }


}
