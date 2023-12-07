package com.yinghu.yinghu.myThread.threadpool;

import java.util.concurrent.*;

/**
 * @Classname MyThreadPool
 * @Description TODO
 * @Date 2022/9/11 15:50
 * @Created by whz
 */
public class MyThreadPool {
    /*前提知识是线程
     * 搞清楚线程的生命周期
     * 线程和资源的关系
     *
     *
     *
     * */

    /*使用多线程，需要考虑是否需要确定资源的类型
    判断该资源类型是否是可以并发操作
    涉及到一个线程安全的问题
    */


    //通常的线程池分为几种
    //1.固定线程池 FixedThreadPool
    /*
     * 该线程池创建好，会有一个固定的阈值，随着任务的不断增加
     * 会一直创建线程，直到线程的最大数是阈值，当中途有其他的线程因异常而中断，我们需要
     * */

    //2.可缓存线程池


    //关于继承关系的一些观点和看法
    //一个父类，可以有多个子类，但是子类，却不能有多个父类
    //当子类编写构造函数的时候，如果父类有显式的有参构造函数
    //

    //BlockingQueue 一般有几种
    //1.ArrayBlockingQueue
    //2.LinkedBlockingQueue
    //3.SynchronousQueue
    //4.DelayQueue
    //5.PriorityBlockingQueue
    //6.LinkedTransferQueue


    public static void main(String[] args) {
        //固定线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        //缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //单一线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        //
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);

        //新建4个线程任务

        fixedThreadPool.isShutdown();

        //fixedThreadPool.invokeAll();

        //存活时间，也就是keepalive，如果过线程空闲的时间超过了这个时间，那么就会自动终结
        //5个必选参数，两个可选参数
        //根据参数的不同来区分不同的线程池功能不同
        //根据队列功能的不同来决定线程池的不同
        //


        //缓存线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 10,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        ThreadPoolExecutor fixThreadPoolExecutor = new ThreadPoolExecutor(5,
                10,
                1000,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(50));
        for (int i= 0;  i< 100; i++) {
            int index=i;
            fixThreadPoolExecutor.execute(() ->{

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("当前第"+ index +"条" + Thread.currentThread().getName() + "执行了");
            });
        }

        fixThreadPoolExecutor.shutdown();


        LinkedTransferQueue linkedTransferQueue = new LinkedTransferQueue<>();

        Executors.newCachedThreadPool();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ExecutorService newWorkStealingPool = Executors.newWorkStealingPool();
        Executors.newSingleThreadScheduledExecutor();






    }


}
