package com.yinghu.yinghu.mynetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.oio.OioServerSocketChannel;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-23
 */
public class NettyOioServer {

    public void server(int port) throws Exception {


        final ByteBuf buf = Unpooled.unreleasableBuffer(
                Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8"))
        );
        //创建阻塞循环事件组
        EventLoopGroup group = new OioEventLoopGroup();

        try {
            //
            ServerBootstrap b = new ServerBootstrap();
           // b.group(group)
                    //允许使用阻塞模式
                    //.channel(OioServerSocketChannel.class)
                    //.localAddress(new InetSocketAddress(port))
                    //.childHandler(new ChannelInitializer<>() {
                    //}


                   // );



        } catch (Exception e) {





        }


    }


}
