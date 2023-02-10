package com.yinghu.yinghu.myThread.ThreadTest;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @创建人 whz
 * @创建时间 2022/12/27
 * @描述
 */
//io这块不是很熟

public class Piped {
    static class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }
        @Override
        public void run() {
            int receive = 0;
            try {
                //这里的receive接收的是数字，每个字符都有对应的数字相对应，然后再转换成字符。
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            }catch (IOException e){

            }
        }
    }

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //将输出流和输入流进行连接，否则将会在使用时抛出异常
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive =0;
        try {
            //只有在流结束的时候，才能赋值失败，返回-1.
            // 而回车只是发送字符的一个结束符，读取的话，还是按逐个读取。
            while ((receive = System.in.read())!=-1) {
                out.write(receive);
            }
            System.out.println("结束");
        }finally {
            out.close();
        }

    }



}
