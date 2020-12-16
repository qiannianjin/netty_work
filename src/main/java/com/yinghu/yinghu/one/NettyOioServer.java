package com.yinghu.yinghu.one;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class NettyOioServer {
//    public void server(int port) throws Exception{
//        final ByteBuf buf = Unpooled.unreleasableBuffer(
//                Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8"))
//        );
//        OioEventLoopGroup group = new OioEventLoopGroup();
//
//        try {
//            ServerBootstrap b = new ServerBootstrap();
////            b.group(group).channel(OioServerSocketChannel.class)
////                    .localAddress(new InetSocketAddress(port))
////                    .childHandler(new ChannelInitializer<SocketChannel>() {
////                    @Override
////                        public void initChannel()
////
////                    })
////        }
//
//        }
//    }




}
