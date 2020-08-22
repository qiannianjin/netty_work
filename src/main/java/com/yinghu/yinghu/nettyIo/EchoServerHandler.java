package com.yinghu.yinghu.nettyIo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
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


    }




}
