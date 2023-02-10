package com.yinghu.yinghu.myThread.ThreadTest;

import java.util.concurrent.TimeUnit;

/**
 * @创建人 whz
 * @创建时间 2022/12/27
 * @描述
 */
public class Profiler {
  private static final ThreadLocal<Long> TIME_THREADLOCAL =new ThreadLocal<Long>(){};
  public static final void begin(){
      System.out.println(System.currentTimeMillis());
      TIME_THREADLOCAL.set(System.currentTimeMillis());
  }

  public static final long end(){
      System.out.println(System.currentTimeMillis());
      return System.currentTimeMillis()-TIME_THREADLOCAL.get();
  }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("cost: " + Profiler.end()+" millis");

    }

    //一段伪代码




}
