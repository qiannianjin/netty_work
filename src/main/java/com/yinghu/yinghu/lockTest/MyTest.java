package com.yinghu.yinghu.lockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @创建人 whz
 * @创建时间 2023/1/1
 * @描述
 */
public class MyTest {
    public class A {
         A(){}
        int a;
    }
    public class B {
        public B(){}
        int b;
    }

     public void test2(String[] args) {
         Lock lock = new ReentrantLock();
         Condition condition = lock.newCondition();



         MyTest myTest = new MyTest();
         A a = new A();

     }

}
