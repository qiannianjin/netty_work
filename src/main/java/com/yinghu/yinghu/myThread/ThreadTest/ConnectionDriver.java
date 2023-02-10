package com.yinghu.yinghu.myThread.ThreadTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;



/**
 * @创建人 whz
 * @创建时间 2022/12/27
 * @描述
 */
//动态代理Connection
//jdk动态代理不熟
public class ConnectionDriver {

    //为什么要通过代理的模式去获取Connection对象。因为，我们先要在每创建一个connecion对象的时候执行一些操作。
    static class ConnectionHandler implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //这就是每次创建对象的时候需要执行的操作。
            if(method.getName().equals("commit")){
                TimeUnit.SECONDS.sleep(100);
            }
            return null;
        }
    }

    public static final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                new Class<?>[] {Connection.class},new ConnectionHandler());
    }


}
