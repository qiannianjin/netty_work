package com.yinghu.yinghu.testTomcat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-28
 */
public class Tomcat {

    private int port = 8080;


    private Map<String, Servlet> servletMap = new HashMap<String, Servlet>();


    private Properties webxml = new Properties();

    /**
     * <p>初始化方法</p>
     *
     * @author luyanan
     * @since 2019/9/19
     */
    private void init() {

        // 加载配置文件并初始化servletMap

        try {
            String path = this.getClass().getResource("/").getPath();
            FileInputStream fis = new FileInputStream(path + "web.properties");
            webxml.load(fis);

            // 初始化 servletMap

            for (Object o : webxml.keySet()) {
                String key = o.toString();
                if (key.endsWith(".url")) {

                    String servletName = key.replaceAll("\\.url$", "");
                    String url = webxml.getProperty(key);
                    // className
                    String className = webxml.getProperty(servletName + ".className");
                    Servlet servlet = (Servlet) Class.forName(className).newInstance();
                    servletMap.put(url, servlet);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void start() {

        init();
        // netty 封装了NIO, Reactor模型. BOss Worker,
        // Boss 线程
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // Worker 线程
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {


            ServerBootstrap bootstrap = new ServerBootstrap();
            //链路式编程
            bootstrap.group(bossGroup, workerGroup)
                    //主线程处理类， 底层使用反射
                    .channel(NioServerSocketChannel.class)
// 子线程处理类
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 无锁化串行编程
                            // Netty 对Http协议的封装,顺序有要求
// HttpResponseEncoder 编码器
                            socketChannel.pipeline().addLast(new HttpResponseEncoder());
                            //HttpRequestDecoder 解码器
                            socketChannel.pipeline().addLast(new HttpRequestDecoder());


                            //  业务处理类
                            socketChannel.pipeline().addLast(new TomcatHandler(servletMap));
                        }
                    })
                    // 针对主线程的配置,分配线程最大数量  128
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //针对子线程的配置, 保持长连接
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // 启动服务区

            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            System.out.println("Tomcat 启动成功, 端口号为: " + this.port);
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //  关闭线程池
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }
    }

    public static void main(String[] args) {
        new Tomcat().start();
    }
}
