package com.yinghu.yinghu.myThread.ThreadTest;

/**
 * @创建人 whz
 * @创建时间 2022/12/26
 * @描述
 */
public class Daemon {
    // daemon是一种支持型线程，如果程序中只剩下daemon线程，那么主线程将结束，但是daemon线程的finally块并不一点执行。
    public static void main(String[] args) {
        Thread daemonRunner = new Thread(new DaemonRunner(), "DaemonRunner");
        daemonRunner.setDaemon(true);
        daemonRunner.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            }finally {
                System.out.println("DaemonThread finally run");
            }
        }
    }


}
