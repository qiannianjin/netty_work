package com.yinghu.yinghu.mynetty;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;

/**
 * @ClassName ChatServer
 * @Description TODO
 * @Author whz
 * @Date 2023/5/23 16:24
 * Version 1.0
 **/
/*
* explanations:
1. 定义ChatMessage、ChatInput、ChatList三个组件。
2. ChatList组件限定消息数量为10条,超过10条时删除第一条消息。
3. useState定义messages存储所有消息,初始化为[]。
4. useEffect每3秒调用getMessagesFromServer获取最新消息,并更新messages。
5. getMessagesFromServer调用后端/messages API获取最新10条消息。
6. sendMessage发送消息,调用后端API发送,并在messages中添加新消息。
7. 如果超过10条,ChatList会调用onDelete删除第一条消息。
后端(Netty):
java*/


public class ChatServer {
    //// 最大Channel数量
    //private static final int MAX_CHANNELS = 10;
    //
    //public void run() {
    //    // 服务端启动时限制Channel数量为10
    //    ChannelFuture channelFuture = bootstrap.bind(port).sync();
    //    channelFuture.channel().closeFuture().sync();
    //}
    //
    //public void channelRead(ChannelHandlerContext ctx, Object msg) {
    //    // 广播消息给所有的Channel
    //    for (Channel channel : channels) {
    //        if (channel != ctx.channel()) {
    //            channel.writeAndFlush(msg);
    //        }
    //    }
    //}
    //
    //public void channelActive(ChannelHandlerContext ctx) {
    //    // 如果超过10个Channel,拒绝新连接
    //    if (channels.size() >= MAX_CHANNELS) {
    //        ctx.channel().close();
    //    } else {
    //        channels.add(ctx.channel());
    //    }
    //}
    //
    //public void channelInactive(ChannelHandlerContext ctx) {
    //    // Channel关闭时,数量-1
    //    channels.remove(ctx.channel());
    //}
    //
    //// /messages API返回最新的10条消息
    //public void getMessages(ChannelHandlerContext ctx) {
    //    JSON gson = new JSONObject();
    //    String json = gson.toJSONString(messages.subList(0, Math.min(10, messages.size())));
    //    ctx.channel().writeAndFlush(json);
    //}
}