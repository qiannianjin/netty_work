package com.yinghu.yinghu.myThread;

public class MyThreadOne extends Thread{


//        Thread thread=new MyThreadOne();

        MyThreadOne myThreadOne= (MyThreadOne) new Thread();

        public static void main(String[] args) {

                MyThreadOne myThreadOne= (MyThreadOne) new Thread();

                System.out.println(
                        myThreadOne.getName()
                );



        }


}
