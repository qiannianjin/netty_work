package com.yinghu.yinghu.myThread.ThreadTest.executorTest;

import java.util.concurrent.*;

/**
 * @ClassName ExecutorTest
 * @Description TODO
 * @Author whz
 * @Date 2023/3/8 4:56
 * Version 1.0
 **/
public class ExecutorTest {


    public static void main(String[] args) {

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {

                Thread thread = new Thread(r,"自定义");
                return thread;
            }
        };
        // ExecutorService executorService = Executors.newFixedThreadPool(10);
        new ThreadPoolExecutor(2,10,0L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(),threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

    }


}
