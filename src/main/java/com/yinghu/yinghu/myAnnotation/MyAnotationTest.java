package com.yinghu.yinghu.myAnnotation;



@Counter
public class MyAnotationTest {

    public static void main(String[] args) throws Exception{

        Counter counter = MyAnotationTest.class.getAnnotation(Counter.class);
        System.out.println(counter.count());
    }

}
