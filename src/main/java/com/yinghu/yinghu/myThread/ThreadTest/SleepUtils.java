package com.yinghu.yinghu.myThread.ThreadTest;

import java.util.concurrent.TimeUnit;

/**
 * @创建人 whz
 * @创建时间 2022/12/24
 * @描述
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            //挂起100秒。 
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e) {

        }
    }
}
