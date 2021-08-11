package com.yinghu.yinghu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MyStream {

    public static void main(String[] args) {


    }

    static public void Test01() {
        //创建流
        ArrayList<String> stringArrayList = new ArrayList<>();
        Stream<String> stream = stringArrayList.stream();
        Stream<String> stringStream = stringArrayList.parallelStream();//并行流
        stream.forEach(System.out::println);
        //

    }

    //使用Arrays中的stream()方法，将数组转成流
    void Test02() {
        Integer[] integers = new Integer[10];
        Stream<Integer> stream = Arrays.stream(integers);
        stream.forEach(System.out::println);
    }

    //使用stream中的静态方法:of(),iterate(),generate()
    static void Test03(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        Stream.iterate(0,(x)->x+2).limit(6);
    }





    //中间操作
    //切片与筛选
    static void test04(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> integerStream1 = integerStream.filter((x) -> x > 5);
        Stream<Integer> distinct = integerStream.distinct();
        Stream<Integer> skip = integerStream.skip(2);
        Stream<Integer> limit = integerStream.limit(2);
        integerStream1.forEach(System.out::println);
    }
    //映射关系
    static void test05(){
        






    }














}
