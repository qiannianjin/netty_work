package com.yinghu.yinghu.nettyTest.chat.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName DiscardServerHandler
 * @Description TODO
 * @Author whz
 * @Date 2023/11/21 21:03
 * Version 1.0
 **/
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    //新建一个set集合
    static Set<Channel> channelList = new HashSet<>();






    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("DiscardServerHandler channelRead");
        String message = (String) msg;
//        Charset gbk = Charset.forName("GBK");
        System.out.println("收到数据：" + message);
//        分发给聊天室内的所有客户端
//        通知其他人 我上线了
        channelList.forEach(e->{
            if(e == ctx.channel()){
                e.writeAndFlush("[自己] ： " + message);
            }else{
                e.writeAndFlush("[客户端] " +ctx.channel().remoteAddress()+"：" + message);
            }
        });

//        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("DiscardServerHandler channelReadComplete");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("DiscardServerHandler exceptionCaught");
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("DiscardServerHandler channelActive");
        //上线操作
        //通知其他人，谁谁上线了
        channelList.forEach(channel -> channel.writeAndFlush("[客户端]"+ctx.channel().remoteAddress()+"上线了"+"\n"));
        channelList.add(ctx.channel());
        ctx.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //下线操作
//通知其他客户端 我下线了
        channelList.remove(ctx.channel());
        //通知其他人 我上线了
        channelList.forEach(e->{
            e.writeAndFlush("[客户端]" + ctx.channel().remoteAddress() + "下线了");
        });
    }



}
