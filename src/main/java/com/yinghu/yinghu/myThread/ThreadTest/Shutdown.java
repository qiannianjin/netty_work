package com.yinghu.yinghu.myThread.ThreadTest;

import java.util.concurrent.TimeUnit;

/**
 * @创建人 whz
 * @创建时间 2022/12/26
 * @描述
 */
public class Shutdown {
    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on =true;

        @Override
        public void run() {
        while(on && !Thread.currentThread().isInterrupted()){
            i++;
        }
            System.out.println("count i ="+ i);

        }
    public void cancel() {
            on = false;
    }

    }

    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread counThread = new Thread(one, "countThread");
        counThread.start();
        TimeUnit.SECONDS.sleep(1);
        counThread.interrupt();
        Runner two = new Runner();
        counThread = new Thread(two, "countThread");
        counThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }


}
