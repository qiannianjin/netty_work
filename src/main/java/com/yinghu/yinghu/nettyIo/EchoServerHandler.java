package com.yinghu.yinghu.nettyIo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

/**
 * @author
 * @describetion ${}
 * @date 2020-8-22
 */


public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public  void channelRead(ChannelHandlerContext ctx,Object msg){

        ByteBuf in = (ByteBuf) msg;
        System.out.println(
                in.toString(CharsetUtil.UTF_8)
        );
        ctx.write(in);

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){

        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);


    }
    @Override
    public void exceptionCaught (ChannelHandlerContext ctx,Throwable cause){

        cause.printStackTrace();
        ctx.close();
    }


}
