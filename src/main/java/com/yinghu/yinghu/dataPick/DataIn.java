package com.yinghu.yinghu.dataPick;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

import javax.sound.sampled.*;
import java.io.*;


public class DataIn {
    public static void main(String[] args) throws Exception {
        test4();
    }


    public static void test() throws Exception {
        File file = new File("F:\\录音保存文件\\测试5.wav");
        file.exists();


        // 音频文件的路径
        String filename = "sample.wav";
        // 创建音频输入流
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
        // 获取音频格式
        AudioFormat format = audioIn.getFormat();
        // 说明混音器支持的音频格式
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        // 获得用于播放的 SourceDataLine
        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
        // 打开语音文件,开始播放
        line.open(format);
        line.start();
        // 开始将音频数据写入混音器
        int nBytesRead = 0;
        byte[] abData = new byte[512];
        while (nBytesRead != -1) {
            nBytesRead = audioIn.read(abData, 0, abData.length);
            if (nBytesRead >= 0) {
                line.write(abData, 0, nBytesRead);
            }
        }
// 完成播放
        line.drain();
        line.close();


        System.out.println();
    }

    public static void test2() throws Exception {
        String inPutFileName = "F:\\录音保存文件\\test.wav";
        String outPutFileName = "F:\\录音保存文件\\copy.wav";
        FileInputStream inputStream = new FileInputStream(new File(inPutFileName));
        FileOutputStream outputStream = new FileOutputStream(new File(outPutFileName));
        if (inputStream != null && outputStream != null) {
            int temp = 0;
            //这个的io真的很慢，每调用一次inputStream都占用很大资源
            while ((temp = inputStream.read()) != -1) {
                outputStream.write(temp);
            }
        }
        inputStream.close();
        outputStream.close();


    }
   public static void test3(){
        String fileName = "hello!";
       System.out.println(fileName.getBytes());
   }

    public static void test4() throws Exception {
        //字节数组
        String str = "ROLLENHOLT";
        ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int temp = 0;
        while ((temp = input.read()) != -1) {
            char ch = (char) temp;
            System.out.println(ch);
            output.write(Character.toLowerCase(ch));
        }
        String outStr = output.toString();
        input.close();
        output.close();
        System.out.println(outStr);
    }

    public static void test5() throws Exception {
        String  fileName = "123456";
        File sourceFile = new File("");
        File targetFile = new File("");
        InputStream in = new FileInputStream(sourceFile);
        OutputStream out = new FileOutputStream(targetFile);
        BufferedInputStream bis = new BufferedInputStream(in);
        BufferedOutputStream bos = new BufferedOutputStream(out);

        byte[] buffer = new byte[1024];  // 使用1KB大小的缓冲区
        int len;
        while ((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        bis.close();
        bos.close();

        System.out.println();
    }




}


