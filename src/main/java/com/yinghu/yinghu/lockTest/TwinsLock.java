package com.yinghu.yinghu.lockTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName TwinsLock
 * @Description TODO
 * @Author whz
 * @Date 2023/2/22 23:55
 * Version 1.0
 **/
public class TwinsLock implements Lock {

    private final Sync sync= new Sync(2);
    public static final class Sync extends AbstractQueuedSynchronizer{

        Sync(int count) {
            if(count<=0){
            throw new IllegalArgumentException("count must large than zero");}
            //将这个sate的值设置大之后，就允许多个线程同时访问加锁的代码块，当然，这是不安全的。
            setState(count);
        }


        //需要重写获取同步进程状态的判断方法，
        public int tryAcquireShared(int reduceCount){
            for(;;){
                int current=getState();
                int newCount = current -reduceCount;
                if (newCount <0|| compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }
        public boolean tryReleaseShared(int returnCount){
            for(;;){
                int current = getState();
                int newCount = current + returnCount;
                if(compareAndSetState(current, newCount)){
                    return true;
                }
            }
        }

    }




    @Override
    public void lock() {

            sync.acquireShared(1);;

    }
    @Override
    public void unlock() {
        sync.tryReleaseShared(1);
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
