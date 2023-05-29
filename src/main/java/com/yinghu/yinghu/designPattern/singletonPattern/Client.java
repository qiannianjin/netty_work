package com.yinghu.yinghu.designPattern.singletonPattern;

/**
 * @ClassName Clent
 * @Description TODO
 * @Author whz
 * @Date 2023/2/23 6:52
 * Version 1.0
 **/
public class Client {
    //单例模式
    public static void main(String[] args) {

    }


    //这是个通用的单例写法,其实就是最原始的饿汉式单例的写法
    static class Singleton{
        private static final Singleton instance = new Singleton();

        //要将构造方法定义成私有方法，这样外界不能够调用确保了单例的安全性
        private Singleton(){}

        public static Singleton getInstance(){

            return instance;


        }

    }







}
