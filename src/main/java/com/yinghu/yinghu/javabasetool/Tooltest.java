package com.yinghu.yinghu.javabasetool;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname Tooltest
 * @Description TODO
 * @Date 2022/8/14 17:47
 * @Created by whz
 */
public class Tooltest {

    private static final Tooltest toolTest = new Tooltest();

    public static void main(String[] args) {

    toolTest.collections();



    }


    //Collections

    void collections(){
        //简单的排序
        Integer a[] ={3,2,1};
        List<Integer> ints = Arrays.asList(a);
        Collections.sort(ints);//升序
        System.out.println(ints);
        Collections.reverse(ints); //降序
        System.out.println(ints);

        //获取最大值

        System.out.println(Collections.max(ints));

        System.out.println(Collections.min(ints));

        //转换成线程安全的集合
        List<Integer> integers = Collections.synchronizedList(ints);
        //底层逻辑会加锁,synchronized关键字
        System.out.println("integers = " + integers);

        //空集合返回
        System.out.println("Collections.emptyList() = " + Collections.emptyList());

        //二分查找
        System.out.println("Collections.binarySearch(ints,2) = " + Collections.binarySearch(ints, 2));

        //变成不可修改集合
        System.out.println("Collections.unmodifiableList(ints) = " + Collections.unmodifiableList(ints));

    }


    //CollectionsUtils

    //Lists

    //Objects

    //BooleanUtils

    //StringUtils

    //Assert

    //IOUtils

    //MDC

    //ClassUtils

    //BeanutUtils

    //ReflectionUtils

    //Base64Utils

    //StandardCharsets

    //DigestUtils

    //SerializationUtils

    //HttpStatus










}
