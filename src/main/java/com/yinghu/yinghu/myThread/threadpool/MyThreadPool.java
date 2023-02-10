package com.yinghu.yinghu.myThread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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




    }


}
