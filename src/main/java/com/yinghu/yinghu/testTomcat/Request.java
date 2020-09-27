package com.yinghu.yinghu.testTomcat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-23
 */
public class Request {

    private ChannelHandlerContext chc;


    private HttpRequest httpRequest;

    public Request(ChannelHandlerContext chc, HttpRequest httpRequest) {
        this.chc = chc;
        this.httpRequest = httpRequest;
    }


    public String getUrl() {
        return this.httpRequest.uri();
    }

    public String getMethod() {
        return httpRequest.method().name();
    }




}
