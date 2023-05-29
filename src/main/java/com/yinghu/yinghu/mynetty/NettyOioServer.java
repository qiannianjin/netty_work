package com.yinghu.yinghu.mynetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;

import javax.swing.text.html.Option;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Optional;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-23
 */
public class NettyOioServer {

    public void server(int port) throws Exception {


        final ByteBuf buf = Unpooled.unreleasableBuffer(
                Unpooled.copiedBuffer("Hi!\r\n", StandardCharsets.UTF_8)
        );
        //创建阻塞循环事件组
        EventLoopGroup group = new OioEventLoopGroup();

        HashMap<Object, Object> map = new HashMap<>();

        Optional<String> nameOpt = Optional.of("张三");
        Optional<String> empty = Optional.empty();
        String s = nameOpt.get();


        String name = nameOpt.get();   // name = "张三"
        String emptyName = empty.get(); // NoSuchElementException
        String name1 = nameOpt.orElse("默认值");    // name = "张三"
        String emptyName1 = empty.orElse("默认值"); // emptyName = "默认值"
        String name2 = nameOpt.orElseGet(() -> "默认值");
        nameOpt.ifPresent(name0 -> System.out.println(name));  // 打印张三
        empty.ifPresent(name5 -> System.out.println(name));    // 不做任何操作
        Optional<String> upperName = nameOpt.map(String::toUpperCase);
        upperName.ifPresent(name6 -> System.out.println(name)); // 打印ZHANGSAN

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
