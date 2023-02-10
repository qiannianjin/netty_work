package com.yinghu.yinghu.myThread.ThreadTest;

import java.util.concurrent.TimeUnit;

/**
 * @创建人 whz
 * @创建时间 2022/12/27
 * @描述
 */
public class Join {
    static class Domino implements Runnable{
        private Thread thread;
        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                //如果这个thread线程没有结束，那么，thread.join就没办法返回，也就是说，会一直卡在这
                thread.join();
                SleepUtils.second(5);
            } catch (InterruptedException e){

            }
            System.out.println(Thread.currentThread().getName()+" terminate.");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            //每一个线程都拥有前一个线程的引用，因为线程的创建时用前一个线程的。
            //如果需要终止，需要等待前一个线程终止，才能从等待总返回。
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous=thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");

    }



}
