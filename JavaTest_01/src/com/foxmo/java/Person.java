package com.foxmo.java;

public class Person {
    public String name;
    public String date;
    public char sex;

    public String printName(){
        return name;
    }

    /**
     * 显示年龄
     * @return 当前年龄
     */
    public int printAge(){
        String year = date.substring(0, 4);
        return (2022 - Integer.parseInt(year));
    }

    public Person() {
    }

    public Person(String name, String date, char sex) {
        this.name = name;
        this.date = date;
        this.sex = sex;
    }

    public static void main(String[] args) {
        Person person = new Person("张三丰","20000528",'男');
        System.out.println("姓名为：" + person.printName());
        System.out.println("年龄为：" + person.printAge());
    }
}
