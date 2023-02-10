package com.yinghu.yinghu.myThread.ThreadTest;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @创建人 whz
 * @创建时间 2022/12/22
 * @描述
 */
public class MultiThread {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for(ThreadInfo threadInfo : threadInfos){
            System.out.println("threadInfo.getThreadId() + threadInfo.getThreadName() " + threadInfo.getThreadId() + threadInfo.getThreadName());

        }

        //ThreadInfo[] threadInfos1 = threadMXBean.dumpAllThreads(true, true);
        //for(ThreadInfo threadInfo : threadInfos1){
        //    System.out.println("threadInfo.getThreadId() + threadInfo.getThreadName() " + threadInfo.getThreadId() + threadInfo.getThreadName());
        //
        //}


    }
}
