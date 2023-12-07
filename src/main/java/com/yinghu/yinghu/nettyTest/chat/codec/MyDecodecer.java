package com.yinghu.yinghu.nettyTest.chat.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @ClassName MyDecodecer
 * @Description TODO
 * @Author whz
 * @Date 2023/11/28 20:35
 * Version 1.0
 **/
public class MyDecodecer extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        //如果数据长度小于4个字节，也就是一个整形，
        //按字节读取，但是，一个字节是8位，所以每读取一个字节，寻址会有8位
        //还是说数据的最小读取是一个字节，也就是8位
        //会不会和计算机每次读取的位数有关
        if(in.readableBytes()< 4){
            return;
        }
        int i = in.readInt();
        if(in.readableBytes() < i){
            //如果数据长度不够，那么就重置读取位置，返回
            //也就是,前面读取了4个字节，但是，后面读取的字节数不够，那么返回到之前的4个字节的位置
            in.resetReaderIndex();
            return;
        }
        byte[] bytes = new byte[i];
        in.readBytes(bytes);
        System.out.println(new String(bytes));
        in.markReaderIndex();

    }
}
