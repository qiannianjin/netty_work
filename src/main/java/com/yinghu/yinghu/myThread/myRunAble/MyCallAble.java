package com.yinghu.yinghu.myThread.myRunAble;

import java.util.concurrent.Callable;

public class MyCallAble implements Callable {
    @Override
    public Object call() throws Exception {
        return null;
    }

    public static void main(String[] args) {

        Callable myCallAble = new MyCallAble();
      //  Thread thread =new Thread(myCallAble);



    }


}
