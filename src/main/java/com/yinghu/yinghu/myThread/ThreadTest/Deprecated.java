package com.yinghu.yinghu.myThread.ThreadTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @创建人 whz
 * @创建时间 2022/12/26
 * @描述
 */
public class Deprecated {
    static class Runner implements Runnable{
        @Override
        public void run() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true){
                System.out.println(Thread.currentThread().getName() + ": " + simpleDateFormat.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "PrintThread");
        printThread.setDaemon(false);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        printThread.suspend();
        System.out.println("main suspend PrintThread at"+simpleDateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        printThread.resume();
        System.out.println("main resume PrintThread at"+simpleDateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        printThread.stop();
        System.out.println("main stop PrintThread at"+simpleDateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);




    }


}
