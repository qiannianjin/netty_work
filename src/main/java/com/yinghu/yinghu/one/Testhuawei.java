package com.yinghu.yinghu.one;

/**
 * @ClassName Testhuawei
 * @Description TODO
 * @Author whz
 * @Date 2023/12/6 20:46
 * Version 1.0
 **/
public class Testhuawei {

    //华为算法面试
    //一个人买汽水，一块钱一瓶汽水，三个瓶盖可以换一瓶汽水，两个空瓶可以换一瓶汽水，问20块可以买多少瓶汽水。
    //递归解法
    static int total =0;

    public static void main(String[] args) {
        System.out.println("hello world");


        fn(20,0,0);
        System.out.println(total);

    }

    public static void fn(int n, int j , int k) {
        //只有在第一次的时候才赋值

        if(total==0){
            total=n;
        }

        int a= (j+n)/2;
        int j2=(j+n)%2;
        int b=(k+n)/3;
        int k2=(k+n)%3;

        total = total + a+b;

        //这个临界条件可能要改一下，虽然结果是对的
        //

       if( (a+b+j2)>=2 || (a+b+k2)>=3)
       {   fn(a+b,j2,k2);}

//        if(a+b>0){
//            fn(a+b,j2,k2);
//        }


    }
}
