package com.yinghu.yinghu.nettyTest.heartbeat;

import com.yinghu.yinghu.nettyTest.heartbeat.server.DiscardServer;

/**
 * @ClassName Starter
 * @Description TODO
 * @Author whz
 * @Date 2023/11/27 16:22
 * Version 1.0
 **/
public class Starter {


    public static void main(String[] args) throws Exception {
        new DiscardServer(9001).run();
    }


}
