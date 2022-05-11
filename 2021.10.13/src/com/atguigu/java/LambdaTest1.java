package com.atguigu.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author lixhui
 * @create 2021-10-10:54
 *
 * 1.举例：(o1,o2) -> Integer.compare(o1,o2);
 * 2.格式：
 *          -> : lambda操作符或箭头操作符
 *          -> 左边：lambda形参列表（其实就是接口中抽象方法的形参列表）
 *          -> 右边：lambda体（其实就是重写的抽象方法的方法体）
 * 3.Lambda表达式的使用 （分为 6 种情况介绍）
 * 4.Lambda表达式的本质：作为函数式接口的实例
 * 5.如果一个接口中，值声明了一个抽象方法，则此接口就称为函数式接口
 *
 */
public class LambdaTest1 {
    //语法格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天门");
            }
        };

        runnable.run();
        System.out.println("*************************");

        Runnable runable1 = () -> {
            System.out.println("我想去北京天门");
        };

        runable1.run();

    }

    //语法格式一：有参，无返回值
    @Test
    public void test2(){
        Consumer<String> com = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        com.accept("谎言和誓言的区别是什么？");

        System.out.println("********************************");

        Consumer<String> com1 = (String s) -> {
            System.out.println(s);
        };

        com1.accept("一个是听的人当真了，一个是说的人当真了");
    }

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为"类型推断"
    @Test
    public void test3(){
        Consumer<String> com1 = (String s) -> {
            System.out.println(s);
        };

        com1.accept("一个是听的人当真了，一个是说的人当真了");
        System.out.println("***************************");
        Consumer<String> com2 = (s) -> {
            System.out.println(s);
        };

        com1.accept("一个是听的人当真了，一个是说的人当真了");
    }

    //语法格式四：Lambda若只需要一个参数时，参数的小括号也可以省略
    @Test
    public void test4(){
        Consumer<String> com1 = (s) -> {
            System.out.println(s);
        };

        com1.accept("一个是听的人当真了，一个是说的人当真了");
        System.out.println("***************************");
        Consumer<String> com2 = s -> {
            System.out.println(s);
        };

        com1.accept("一个是听的人当真了，一个是说的人当真了");
    }

    //语法格式五：Lambda需要两个或两个以上的参数，多条执行语句，并且可以由返回值
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(com1.compare(23, 49));

        System.out.println("******************************");
        Comparator<Integer> com2 = (o1,o2) ->{
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };
        System.out.println(com2.compare(27, 21));

    }

    //语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test6(){
        Comparator<Integer> com1 = (o1,o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12, 8));
        System.out.println("************************");

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);

        System.out.println(com2.compare(12, 28));
    }
}
