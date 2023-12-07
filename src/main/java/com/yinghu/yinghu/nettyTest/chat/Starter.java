package com.yinghu.yinghu.nettyTest.chat;

import com.yinghu.yinghu.nettyTest.chat.server.DiscardServer;

/**
 * @ClassName Starter
 * @Description TODO
 * @Author whz
 * @Date 2023/11/21 21:04
 * Version 1.0
 **/
public class Starter {

    public static void main(String[] args) throws Exception {
        DiscardServer discardServer = new DiscardServer(8000);
        discardServer.start();


    }
}
