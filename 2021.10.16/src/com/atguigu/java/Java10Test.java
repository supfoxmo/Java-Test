package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixhui
 * @create 2021-10-10:19
 */
public class Java10Test {
    //copyOf(Xxx coll):如果参数coll本身就是一个只读集合，则copyOF()返回即为当前的集合coll
    //如果参数coll不是一个只读集合，则返回一个新的集合，该集合是只读的
    @Test
    public void test1(){
        List<String> list = List.of("Java", "Python", "C#");
        List<String> copy = List.copyOf(list);
        System.out.println(list == copy);//true

        ArrayList<String> list1 = new ArrayList<>();
        List<String> copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1);//false
    }
}
