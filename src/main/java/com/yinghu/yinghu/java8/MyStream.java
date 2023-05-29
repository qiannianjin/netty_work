package com.yinghu.yinghu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream {

    static List<String> fruitList = Arrays.asList("apple", "banana", "orange");


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
    static void Test03() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        Stream.iterate(0, (x) -> x + 2).limit(6);
    }


    //中间操作
    //切片与筛选
    static void test04() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> integerStream1 = integerStream.filter((x) -> x > 5);
        Stream<Integer> distinct = integerStream.distinct();
        Stream<Integer> skip = integerStream.skip(2);
        Stream<Integer> limit = integerStream.limit(2);
        integerStream1.forEach(System.out::println);
    }

    //映射关系
    static void test05() {


    }


    //遍历
    static void testing3() {

        //lambda表达式主要有4种选择
        //反正形式都基本一样，或者差不多()->{}
        //但是返回类型不一样，有predicate（返回boolean），comsumer（无返回），funtion（直接写处理逻辑）


        fruitList.forEach(System.out::println);
        fruitList.stream().forEach(System.out::println);

        //排序
        fruitList.stream().sorted((o1, o2) -> o1.compareTo(o2));
        //过滤
        fruitList.stream().filter((o1)->{
            return o1.isEmpty();
        });
        fruitList.stream().filter(s1->s1.startsWith("a")).collect(Collectors.toList());
        //映射

        //map，将元素转换
        fruitList.stream().map(s -> s.length());


        //fruitList.stream().flatMap()
        ////归约
        //fruitList.stream().reduce()
        //分组



        //函数式接口表达
        //线程创建
        //进行optional的操作

        Optional.ofNullable(fruitList).ifPresent(System.out::println);

        //进行Stream流操作



    }


    public static void main(String[] args) {
        testing3();

    }


}
