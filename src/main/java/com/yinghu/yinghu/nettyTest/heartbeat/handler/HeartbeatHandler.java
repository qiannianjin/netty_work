package com.yinghu.yinghu.nettyTest.heartbeat.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @ClassName HeartbeatHandler
 * @Description TODO
 * @Author whz
 * @Date 2023/11/22 12:16
 * Version 1.0
 **/
public class HeartbeatHandler extends ChannelInboundHandlerAdapter {


    int readTimeOut = 0;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        //连接事件
        IdleStateEvent event = (IdleStateEvent) evt;

        //idle是空闲的意思，空闲状态，就是没有数据交互，超过3次，就断开连接
        if(event.state() == IdleState.READER_IDLE){
            readTimeOut++;
        }

        if(readTimeOut >= 3){
            System.out.println("超时超过3次，断开连接");
            ctx.close();
        }

        System.out.println("触发了：" + event.state() + "事件"+"第"+readTimeOut+"次超时");
    }





}
