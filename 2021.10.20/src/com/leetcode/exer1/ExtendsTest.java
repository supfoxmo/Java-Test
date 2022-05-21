package com.leetcode.exer1;

/**
 * @author lixhui
 * @create 2021-10-13:54
 */
public class ExtendsTest {
    public static void main(String[] args) {
        Person person = new Person("张三丰",1010,1236463426);

        person.sleep();

        person.eat();

        Creatrue crea = person;

        //错误
//        crea.work();
    }
}
