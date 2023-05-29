package com.yinghu.yinghu.designPattern.singletonPattern;

/**
 * @ClassName HungryStaticSingleton
 * @Description TODO
 * @Author whz
 * @Date 2023/2/23 8:34
 * Version 1.0
 **/

//饿汉式的单例写法,静态块单例模式
public class HungryStaticSingleton{

    private static final HungryStaticSingleton hungrySingleton;

    static {
        hungrySingleton = new HungryStaticSingleton();
    }
    private HungryStaticSingleton(){}
    public static HungryStaticSingleton getInstance(){
        return hungrySingleton;
    }




}
