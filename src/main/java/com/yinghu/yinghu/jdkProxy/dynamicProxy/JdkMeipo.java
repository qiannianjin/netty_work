package com.yinghu.yinghu.jdkProxy.dynamicProxy;

import com.yinghu.yinghu.jdkProxy.staticProxy.IPerson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @创建人 whz
 * @创建时间 2022/12/30
 * @描述
 */
public class JdkMeipo implements InvocationHandler {
    private IPerson target;

    public IPerson getInstance(IPerson target){
        this.target=target;
        Class<?> clazz=target.getClass();
        //最后一个参数为实现InvacationHandler的对象，本例中可以用this表示,只能是本身
        // 第一个为类加载器，第二个为返回的类型（可以时接口，也可以是类）.
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }
    private void after(){
        System.out.println("双方同意,开始交往");
    }
    private void before(){
        System.out.println("我是媒婆，已经收集到你的需求，开始物色");
    }

}
