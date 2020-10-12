package com.yinghu.yinghu.testTomcat;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Map;

/**
 * @author
 * @describetion ${}
 * @date
 */
public class TomcatHandler extends ChannelInboundHandlerAdapter {

    private Map<String, Servlet> servletMap = null;

    public TomcatHandler(Map<String, Servlet> servletMap) {
        this.servletMap = servletMap;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) msg;
            Request request = new Request(ctx, httpRequest);

            Response response = new Response(ctx, httpRequest);

            String url = request.getUrl();
            if (servletMap.containsKey(url)) {
                servletMap.get(url).service(request, response);
            } else {
                response.write("404 - Not Found");
            }
        }
    }
}
