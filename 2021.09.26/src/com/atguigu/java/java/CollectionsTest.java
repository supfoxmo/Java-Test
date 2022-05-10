package com.atguigu.java.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections:操作Collection、Map的工具类
 *
 * 面试题：Colletion和Collections的区别
 *
 * @author lixhui
 * @create 2021-09-22:13
 */

/*
 * Collections:操作Collection、Map的工具类：
 *
 * 1、reverse(List):反转List中元素的顺序
 * 2、shuffle(List):对List集合元素进行随机排序
 * 3、sort(List):根据元素的自然顺序对指定的List集合元素按升序排序
 * 4、sort(List,Comparator):根据指定的Comparator产生的顺序对List集合元素进行交换
 * 5、Object max(Collection):根据元素自然顺序，返回给定集合中的最大值
 * 6、Object max(Collection,Comparator):根据Comparator指定的顺序，返回指定集合的最大值
 * 7、Object min(Collection):根据元素自然顺序，返回给定集合中的最小值
 * 8、Object min(Collection,Comparator):根据Comparator指定的顺序，返回指定集合的最小值
 * 9、int frequancy(Collection,Object):返回指定集合中指定元素的出现次数
 * 10、void cope(List dest,List src):将stc中的内容复制到dest中
 * 11、boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换List对象的旧值
 */

public class CollectionsTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add("zhouyini");
        list.add("weijin");
        list.add("mahailing");
        list.add("lixhui");

        System.out.println(list);
        System.out.println("*******************************");

        Collections.reverse(list);
        System.out.println(list);
        System.out.println("*******************************");

        Collections.shuffle(list);
        System.out.println(list);
        System.out.println("*******************************");

        Collections.sort(list);
        System.out.println(list);
        System.out.println("*******************************");

//        Collections.sort(list, new Comparator() {
//            if(True){
//
//            }
//        });
//        System.out.println(list);
//        System.out.println("*******************************");

        Collections.swap(list,1,3);
        System.out.println(list);
        System.out.println("*******************************");

    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add("zhouyini");
        list.add("weijin");
        list.add("mahailing");
        list.add("lixhui");

        System.out.println(list);
        System.out.println("*******************************");

        //报异常：java.lang.IndexOutOfBoundsException: Source does not fit in dest
        // (原因：deat.size > list.size)
//        ArrayList dest = new ArrayList();
//        Collections.copy(dest,list);
//        System.out.println(list);
//        System.out.println("*******************************");

        //正确方法
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(list);
        System.out.println("*******************************");

    }
}
