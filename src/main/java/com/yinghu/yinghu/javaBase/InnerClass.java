package com.yinghu.yinghu.javaBase;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class InnerClass {


    public static void main(String[] args) {








    }
    //如果你不经常用，你就会忘记
    //内部类有什么好处，有什么特点
    //
 /**
  * @description:
  * @author: whz
  * @date: 2021/2/6 21:14
  * @param: null
  * @return:
  */
    public void my() throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        Class servletClass = null;
        Servlet servlet=(Servlet) servletClass.newInstance();

        HttpServletRequest httpServletRequest;


        //通过对象或者类，获取到类的信息
        this.getClass();
        //通过类的路径获取到类的的基本信息
        Class<?> innerClass = Class.forName("InnerClass");


        Collection collection = Collections.emptyList();


        Vector vector=new Vector();

        Iterator Iterator;


    }



}
