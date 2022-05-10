package com.atguigu.java.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixhui
 * @create 2021-09-20:35
 */

//自定义泛型类
public class Person<T> {
    private String name;
    private int age;
    private T wife;

    public void design(T wife){
        System.out.println(name + "'s wife is " + wife);
    }

    //静态方法中不能使用类的泛型
    //原因：静态方法是随着类的加载而加载的，而泛型是在实例化时指名的
//    public static void show(T wife){
//        System.out.println(name + "'s wife is " + wife);
//    }

    //泛型方法：与方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
    //换句话说，泛型方法与所属的类是不是泛型类都没有关系
    //泛型方法可以声明为静态的，原因：泛型参数是在调用方法时确定的。并非在实例化时确定的
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for (E e : arr){
            list.add(e);
        }
        return list;

    }

    public Person() {
        //编译不通过
//        T[] arr = new T[10];
        //编译通过
        T[] arr = (T[])new Object[10];

    }

    public Person(String name, int age, T wife) {
        this.name = name;
        this.age = age;
        this.wife = wife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T getWife() {
        return wife;
    }

    public void setWife(T wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", wife=" + wife +
                '}';
    }
}
