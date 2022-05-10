package com.atguigu.java.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 有限制条件的通配符：
 *     ? extends Person:
 *     ? super Person:
 *
 *
 * @author lixhui
 * @create 2021-09-22:51
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //extends 相当于 <=
        List<? extends Person> list1 = null;
        //super 相当于 >=
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
        //编译不通过
//        list1 = list5;

        //编译不通过
//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //1、读取数据
        list1 = list3;
        Object o = list1.get(0);
        Person p = list1.get(0);
        //编译不通过
//        Student s = list1.get(0);

        list2 = list4;
        Object o1 = list2.get(0);
        //编译不通过
//        Person p1 = list2.get(0);
//        Student s1 = list2.get(0);

        //2、写入数据
        //编译不通过
//        list1.add(new Student());
//        list1.add(new Person());
//        list1.add(new Object());

//        编译通过
        list2.add(new Student());
        list2.add(new Person());
        //编译不通过
//        list2.add(new Object());

    }
}
