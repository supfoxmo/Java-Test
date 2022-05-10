package com.atguigu.java.java;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lixhui
 * @create 2021-09-20:35
 */
public class GenericTest {
    @Test
    public void test1(){
        //如果定义了泛型类，实列化没有知名类的泛型，则认为此泛型类型为Object类型
        Person person = new Person();
        person.setAge(28);
        person.setName("lvbu");
        person.setWife(530);
        System.out.println(person);
        System.out.println("***********************************");
        //方式一：
        Person<String> person1 = new Person<>("lixhui",21,"zhouyini");
        System.out.println(person1);
        person1.design(person1.getWife());
        System.out.println("***********************************");
        //方式二:
//        Person<String> person1 = new Person<String>();
    }

    @Test
    public void test3(){
        Person<String> person = new Person<>("lixhui", 22, "zhouyini");

        List<Integer> list = person.copyFromArrayToList(new Integer[]{1, 2, 3, 4, 5, 6});

        System.out.println(list);
    }

    @Test
    public void test2(){
        //泛型不同的引用不能相互赋值
        //虽然类A是类B的父类，但是G<A>和G<B>二者不具备子父类关系，二者是并列关系。
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Object> list3 = new ArrayList<>();
//        list1 = list2;
//        list3 = list1;
//        list3 = list2;
    }

    //列A是类B的父类或接口，则B<G>可以赋值给A<G>
    @Test
    public void test4(){
        AbstractList<String> list1 = null;//ArrayList的父类
        List<String> list2 = null;//ArrayList的接口
        ArrayList<String> list3= null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();
    }

    //通配符的使用   通配符：?
    //虽然类A是类B的父类，但是G<A>和G<B>二者不具备子父类关系，二者是并列关系。
    //两者共同的父类为：G<?>
    @Test
    public void test5(){
        List<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Object> list3 = new ArrayList<>();

        List<?> list = null;

        list1.add("zhouyini");
        list1.add("lixhui");
        list1.add("weijin");

        list = list1;
        //编译通过
//        list = list2;
//        list = list3;

        //对于List<?>就不能向其内部添加数据
        //除了可以添加null之外
//        list.add("aa");
        list.add(null);

        Object o = list.get(0);
        System.out.println(o);
        System.out.println("**************************");

        print(list1);
        //输出结果：zhouyini
        //         lixhui
        //         weijin
        //         null
        print(list2);
        print(list3);

        System.out.println(list1);//[zhouyini, lixhui, weijin, null]

    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
