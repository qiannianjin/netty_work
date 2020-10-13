package com.yinghu.yinghu.mynetty.myChannel;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

/**
 * @author
 * @describetion ${}
 * @date 2020-10-13
 */
public class MyChannel {

    Bootstrap bootstrap=new Bootstrap();


    ChannelFuture channelFuture=bootstrap.bind(888).sync();


    Channel channel =channelFuture.channel();


    public MyChannel() throws InterruptedException {
    }
}
