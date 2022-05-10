package com.atguigu.java.java;

/**
 * @author lixhui
 * @create 2021-09-20:56
 */

//1、指明了泛型的类型，Student不是泛型类
public class Student extends Person<String>{
    private int id;

    public Student() {
    }

    public Student(String name, int age, String wife, int id) {
        super(name, age, wife);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


//2、未指明泛型的类型，Student<T>任然是泛型类
//public class Student<T> extends Person<T>{
//        private T id;
//
//}
