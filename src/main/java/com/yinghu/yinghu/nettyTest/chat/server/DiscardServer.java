package com.yinghu.yinghu.nettyTest.chat.server;

import com.yinghu.yinghu.nettyTest.chat.handler.DiscardServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;

/**
 * @ClassName DiscardServer
 * @Description TODO
 * @Author whz
 * @Date 2023/11/21 21:04
 * Version 1.0
 **/
public class DiscardServer {

    private int prot;

    public DiscardServer(int prot) {
        this.prot = prot;
    }


    public void start() throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                                      @Override
                                      protected void initChannel(SocketChannel ch) throws Exception {
                                          Charset gbk = Charset.forName("utf-8");
                                          //以数据长度为10进行分割
                                          //ch.pipeline().addLast(new FixedLengthFrameDecoder(10));
                                           ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, Delimiters.lineDelimiter()[0]));
                                          //以下划线为终止符
                                          // ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer("_".getBytes())));
                                          //
                                          ch.pipeline().addLast(new StringDecoder(gbk));
                                          ch.pipeline().addLast(new StringEncoder(gbk));
                                          ch.pipeline().addLast(new DiscardServerHandler());
                                      }
                                  }
                    )
                    .option(ChannelOption.SO_BACKLOG, 128).option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)


            ChannelFuture f = b.bind(prot).sync();
            System.out.println("server start");
            f.channel().closeFuture().sync();

        } finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }


    }


}
