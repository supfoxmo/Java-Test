package com.atguigu.java3;

/**
 * @author lixhui
 * @create 2021-10-23:25
 *
 * Person需要满足如下的要求，方可序列化
 * 1、需要实现接口：Serializable
 * 2、当前类提供一个全局常量（序列版本号）：serialVersionUID
 * 3、除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有的属性也必须是可序列化的。
 * 4、
 */
public class person implements java.io.Serializable {
    private String name;
    private boolean sex;
    private int age;

    private static final long serialVersionUID = 324543467235278L;

    public person() {
    }

    public person(String name, boolean sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
