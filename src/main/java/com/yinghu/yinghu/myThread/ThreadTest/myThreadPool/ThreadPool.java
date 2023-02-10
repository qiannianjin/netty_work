package com.yinghu.yinghu.myThread.ThreadTest.myThreadPool;

/**
 * @创建人 whz
 * @创建时间 2022/12/28
 * @描述
 */
public interface ThreadPool<Job extends Runnable> {
    void excute(Job job);;
    void shutdown();
    void addWorkers(int num);
    void removeWorkers(int num);
    int getJobSize();
}
