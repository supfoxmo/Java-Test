package com.atguigu.java4;

/**
 * @author lixhui
 * @create 2021-10-13:55
 */

@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    public Person(){

    }

    @MyAnnotation(value = "abc")
    private Person(String name){
        this.name = name;
    }

    @MyAnnotation
    Person(String name,int age){
        this.name = name;
        this.age = age;

    }

    private String show(String nation) throws RuntimeException,NullPointerException{
        System.out.println("我的国籍是：" + nation);
        return nation;
    }
    @MyAnnotation(value = "abc")
    public String display(String interest,int num){
        System.out.println("我的兴趣是：" + interest + "，已经 " + num + "年了。");
        return interest;
    }

    private static void showdecs(){
        System.out.println("我是一个可爱的人");
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }
    @MyAnnotation
    @Override
    public int compareTo(String o) {
        return 0;
    }
}
