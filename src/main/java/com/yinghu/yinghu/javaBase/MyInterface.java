package com.yinghu.yinghu.javaBase;

/**
 * @Classname MyInterface
 * @Description TODO
 * @Date 2021/2/8 10:07
 * @Created by whz
 */
public interface MyInterface {

       int i=0;
      public void  my();
      default void  my2(){

          System.out.println("默认实现");
          System.out.println("你好");

      }

}
