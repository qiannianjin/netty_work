package com.yinghu.yinghu.myThread.ThreadTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @创建人 whz
 * @创建时间 2022/12/23
 * @描述
 */
@SuppressWarnings("checkstyle:SummaryJavadoc")
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    @SuppressWarnings("checkstyle:Indentation")
    public static void main(String[] args) throws Exception {

        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        for (Job job : jobs) {
            System.out.println("priority: " + job.priority + ", count: " + job.jobCount);

        }

        //言而总之，线程的优先级并没有决定线程执行的先后顺序。
    }

    @SuppressWarnings("checkstyle:Indentation")
    static class Job implements Runnable {
        private int priority;
        private AtomicInteger jobCount = new AtomicInteger();

        public Job(int priority) {
            this.priority = priority;
        }

        @Override //总体来讲，这段代码的意义在于，notStart=false,全部的10条线程一直处于停然后10个线程就一直在count++;
        //
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount.incrementAndGet();
            }
        }
    }
}
