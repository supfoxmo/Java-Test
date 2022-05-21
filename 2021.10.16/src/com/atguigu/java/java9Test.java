package com.atguigu.java;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author lixhui
 * @create 2021-10-22:49
 */
public class java9Test {

//    java8中的写法：创建只读集合
    @Test
    public void test1(){
        List<String> nameList = new ArrayList<>();
        nameList.add("Tom");
        nameList.add("Make");
        nameList.add("Jerry");
        //Collections类中的unmodifiableList(E e):返回一个nameList的只读的集合
        nameList = Collections.unmodifiableList(nameList);

        //UnsupportedOperationException
//        nameList.add("Mary");

        System.out.println(nameList);

    }

    @Test
    public void test2(){
        //Arrays.asList()：返回一个只读集合
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //UnsupportedOperationException
//        list.add(9);

        System.out.println(list);
    }

    //java9新特性：集合工厂方法：创建只读集合
    @Test
    public void test3(){
        //返回一个只读集合
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        //UnsupportedOperationException
//        list.add(9);

        System.out.println(list);

        Set<Integer> integerSet = Set.of(1, 2, 3, 4, 5, 6, 7, 8);
        //方式一：
        Map<String, Integer> integerMap = Map.of("Tom", 23, "Make", 18, "Jerry", 28);
        //方式二：
        Map<String, Integer> integerMap1 = Map.ofEntries(Map.entry("Mark", 21), Map.entry("Joker", 22));

        System.out.println(integerMap1);
    }

    //java9新特性：InputStream的新方法：tranferTo()
    @Test
    public void test4(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        try {
            InputStream is = classLoader.getResourceAsStream("hello.txt");
            FileOutputStream fos = new FileOutputStream("src\\hello1.txt");

            //把输入流中所有的数据直接自动地复制到输出流中
            long len = is.transferTo(fos);
            System.out.println(len);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
