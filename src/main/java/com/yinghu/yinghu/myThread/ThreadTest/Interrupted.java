package com.yinghu.yinghu.myThread.ThreadTest;

import java.util.concurrent.TimeUnit;

/**
 * @创建人 whz
 * @创建时间 2022/12/26
 * @描述
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        //不停尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        //不停地运行
        Thread busyThread = new Thread(new BusyRunner(), "busyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleepThread interrupted is " + sleepThread.isInterrupted());;
        System.out.println("busyThread interrupted is " + busyThread.isInterrupted());;
        while(true){
            SleepUtils.second(20000);
        }

    }
    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
