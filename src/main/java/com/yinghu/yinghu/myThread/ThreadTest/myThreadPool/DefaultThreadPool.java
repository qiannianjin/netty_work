package com.yinghu.yinghu.myThread.ThreadTest.myThreadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @创建人 whz
 * @创建时间 2022/12/28
 * @描述
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //线程池最大限制数
    private static final int MAX_WORKER_NUMBERS =10;
    private static final int DEFAULT_WORKER_NUMBERS =5;
    private static final int MIN_WORKER_NUMBERS =1;
    private final LinkedList<Job> jobs =new LinkedList<Job>();
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    private int workerNum =DEFAULT_WORKER_NUMBERS;
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool(){
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num){
        workerNum= num>MIN_WORKER_NUMBERS?MAX_WORKER_NUMBERS:num<MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS:num;
        initializeWorkers(workerNum);

    }




    @Override
    public void excute(Job job) {
        if(job!=null){
            //添加一个工作，然后进行通知，符合范式，显示加锁，然后处理，通知，最后释放。
            synchronized(jobs){
                jobs.addLast(job);
                jobs.notifyAll();
            }
        }
    }

    @Override
    public void shutdown() {
        for(Worker worker : workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
            synchronized (jobs){
                // 限制新增的Work数量不能超过最大值。
                if(num + this.workerNum>MIN_WORKER_NUMBERS){
                    num=MAX_WORKER_NUMBERS-this.workerNum;
                }
                initializeWorkers(num);
                this.workerNum+=num;

            }
    }

    @Override
    public void removeWorkers(int num) {
            synchronized (jobs){
                if(num>this.workerNum){
                    throw new IllegalStateException("beyond workerNum");
                }
                int count=0;
                while(count <num){
                    Worker worker = workers.get(count);
                    if(workers.remove(worker)){
                        worker.shutdown();
                        count++;
                    }

                }
                this.workerNum-=count;
            }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }


    class Worker implements Runnable {
    private volatile boolean running = true;

        @Override
        public void run() {
            while (running){
                Job job =null;
                synchronized (jobs){
                    while (jobs.isEmpty()) {
                        try{
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job=jobs.removeFirst();
                }
                if(job!=null){
                    try {
                        job.run();
                    } catch (Exception e) {

                    }
                }
            }
        }
        public void shutdown(){
            running = false;
        }


    }


}
