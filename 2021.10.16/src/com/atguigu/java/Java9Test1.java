package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author lixhui
 * @create 2021-10-23:31
 */
public class Java9Test1 {
    //java9新特性：Stream API 的新增方法：
    // takeWhile():返回从头开始满足条件的元素，直到遇见不符合条件的元素为止
    // dropWhile():与takeWhile()相反，返回第一个不符合条件的元素开始以及之后的所有元素
    // ofNullable(T t):参数能存储单个null值，不会报异常
    // iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)

    @Test
    public void test(){
        List<Integer> list = Arrays.asList(23, 31, 45, 29, 10, 68, 64, 56, 92, 21, 18);
        //takeWhile():返回从头开始满足条件的元素，直到遇见不符合条件的元素为止
        list.stream().takeWhile(i -> i < 60).forEach(System.out::println);

        System.out.println("*********************");

        //dropWhile():与takeWhile()相反，返回第一个不符合条件的元素开始以及之后的所有元素
        list.stream().dropWhile(i -> i < 60).forEach(System.out::println);
    }

    @Test
    public void test1(){
        //of()参数中的多个元素，可以包含null值
        Stream<Integer> stream = Stream.of(1, 2, 3, null);
        System.out.println(stream);
        //of()参数不能存储单个null值，否则会报异常
//        Stream<Object> stream1 = Stream.of(null);
//        System.out.println(stream1);

        Stream<Object> stream1 = Stream.of(null,null);
        System.out.println(stream1);

        System.out.println("************************");

        //ofNullable(T t):参数能存储单个null值，不会报异常
        Integer i = 10;
        Stream<Integer> i1 = Stream.ofNullable(i);
        System.out.println(i1);

        Double d = null;
        Stream<Double> d1 = Stream.ofNullable(d);
        System.out.println(d1.count());

    }

    @Test
    public void test2(){
        Stream.iterate(0,x -> x + 1).limit(10).forEach(System.out::println);

        System.out.println("***************");

        //java9新增的iterate重载方法
        Stream.iterate(0,x -> x < 100,x -> x + 1).forEach(System.out::println);

    }

    //java9新特性：Optional提供的新的方法stream()
    //可以将Optional类转化为Stream类
    @Test
    public void test3(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Tom");
        list.add("Mark");
        list.add("Jerry");

        Optional<ArrayList<String>> optional = Optional.ofNullable(list);
        Stream<ArrayList<String>> stream = optional.stream();

//        long count = stream.count();
//        System.out.println(count);//1

        stream.flatMap(x -> x.stream()).forEach(System.out::println);

    }

}
