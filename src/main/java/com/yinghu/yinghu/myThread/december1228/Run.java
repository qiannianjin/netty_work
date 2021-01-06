package com.yinghu.yinghu.myThread.december1228;

public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum=new HasSelfPrivateNum();
        ThreadA threadA=new ThreadA(hasSelfPrivateNum);
        threadA.start();
        ThreadB threadB=new ThreadB(hasSelfPrivateNum);
        threadB.start();
    }
}
