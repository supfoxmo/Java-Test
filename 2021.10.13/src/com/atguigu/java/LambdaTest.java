package com.atguigu.java;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author lixhui
 * @create 2021-10-10:06
 *
 * Lambda表达式的写法
 */
public class LambdaTest {
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

        Runnable runable1 = () -> System.out.println("我想去北京天门");

        runable1.run();

    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println(com1.compare(12, 24));

        System.out.println("*****************************");
        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);

        System.out.println(com2.compare(27, 19));

        System.out.println("*****************************");
        //引用方法
        Comparator<Integer> com3 = Integer::compare;

        System.out.println(com3.compare(26, 31));


    }

}
