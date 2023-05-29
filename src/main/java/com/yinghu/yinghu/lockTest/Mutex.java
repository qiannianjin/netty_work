package com.yinghu.yinghu.lockTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @创建人 whz
 * @创建时间 2022/12/30
 * @描述
 */
public class Mutex implements Lock {
    private static class Syn extends AbstractQueuedSynchronizer{
        //判断是否是独占锁
        protected boolean isHeldExclusive (){
            return getState()==1;
        }
        //尝试获取同步状态
        //例子，方法栈，全部的线程公用这一个对象的方法栈，
        //但是很多个线程去获取同步状态，
        public boolean tryAcquire(int acquire){
            if(compareAndSetState(0,1)){
                //没有进行重写，而是调用
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        //尝试
        protected boolean tryRelease(int release){
            if(getState()==0) throw new IllegalMonitorStateException();
            //如果这个getState是0，那就证明，这个同步状态并不是当前线程拥有，那就谈不上什么操作之类的。
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        Condition newCondition() {return new ConditionObject();}
    }


    //这一步在创建锁的时候才执行一次，调用锁的方法啊的时候不会执行。
    private final Syn syn=new Syn();

    //需要重写6个方法
    @Override
    public void lock() {
        syn.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        syn.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
      return syn.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return syn.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
    syn.release(1);
    }

    @Override
    public Condition newCondition() {
        return syn.newCondition();
    }

    public static void main(String[] args) {
        Mutex lock = new Mutex();

        //弄个多线程的线程池来跑


        lock.tryLock();

        lock.unlock();

        System.out.println("你好");
    }

}
