package com.yinghu.yinghu.testTomcat;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.io.UnsupportedEncodingException;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-23
 */
public class Response {



    private ChannelHandlerContext chc;

    private HttpRequest httpRequest;

    public Response(ChannelHandlerContext chc, HttpRequest httpRequest) {
        this.chc = chc;
        this.httpRequest = httpRequest;
    }

    public void write(String out) throws UnsupportedEncodingException {

        if (out == null || out.length() == 0) {
            return;
        }

        try {
            // 设置http协议以及请求头协议
            FullHttpResponse response = new DefaultFullHttpResponse(    // 设置http版本为1.1
                    HttpVersion.HTTP_1_1,
                    // 设置响应状态码
                    HttpResponseStatus.OK,
                    // 将输出值写出 编码为UTF-8
                    Unpooled.wrappedBuffer(out.getBytes("UTF-8")));
            response.headers().set("Content-Type", "text/html;");
// 当前是否支持长连接
//            if (HttpUtil.isKeepAlive(r)) {
//                // 设置连接内容为长连接
//                response.headers().set(CONNECTION, HttpHeaderValues.KEEP_ALIVE);
//            }

            chc.write(response);
            chc.flush();
        } finally {
            chc.close();
        }
    }
}
