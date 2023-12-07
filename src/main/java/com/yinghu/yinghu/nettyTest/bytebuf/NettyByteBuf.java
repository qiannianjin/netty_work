package com.yinghu.yinghu.nettyTest.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @ClassName NettyByteBuf
 * @Description TODO
 * @Author whz
 * @Date 2023/11/22 11:58
 * Version 1.0
 **/
public class NettyByteBuf {
    public static void main(String[] args) {
        //这个byteBuf对象有3个元素要注意
        //一个是索引位置，一个是长度，一个是容量

        // 创建一个byteBuf对象，该对象内部包含一个字节数组byte[10]
        ByteBuf byteBuf = Unpooled.buffer(10);
        System.out.println("byteBuf=" + byteBuf);

        for (int i = 0; i < 8; i++){
            byteBuf.writeByte(i);
        }
        System.out.println("byteBuf=" + byteBuf);

        for (int i = 0; i < 5; i++) {
            //不会改变索引位置
            System.out.println(byteBuf.getByte(i));
        }
        System.out.println("byteBuf=" + byteBuf);

        for (int i = 0; i < 5; i++) {
            //每读一次，索引的位置就向后移动一次
            System.out.println(byteBuf.readByte());
        }
        System.out.println("byteBuf=" + byteBuf);

        //查看有多少可读的字节数
        byteBuf.readableBytes();
        //可以手动标记我们的读索引
        byteBuf.markReaderIndex();
        //重置到上一次读索引的位置
        //比如说一次读8位，那就重置到读8位之前的位置
        //reset到上次标记的读索引
        byteBuf.resetReaderIndex();
    }


}
