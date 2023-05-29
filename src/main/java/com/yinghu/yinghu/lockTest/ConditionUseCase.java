package com.yinghu.yinghu.lockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionUseCase
 * @Description TODO
 * @Author whz
 * @Date 2023/3/18 15:16
 * Version 1.0
 **/
public class ConditionUseCase {
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    public void conditionWait() throws InterruptedException{
        lock.lock();
        try {
        condition.await();
        }finally {
            lock.unlock();
        }
    }



}
