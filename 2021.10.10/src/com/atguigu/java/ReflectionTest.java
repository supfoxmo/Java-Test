package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lixhui
 * @create 2021-10-10:00
 */
public class ReflectionTest {
//      反射之前，对于Person的操作
    @Test
    public void test1(){
        Person p1 = new Person("Tom",18);

        //在person类外部，不可以通过person类的对象调用其内部私有的结构
        //比如：name、showNation()以及私有的构造器
        p1.age = 10;
        System.out.println(p1.toString());

        System.out.println(p1);

    }
//     反射之后，对于Person的操作
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;
        //1、通过反射，创建Person类的对象
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());

        //2、通过反射，调用对象指定的属性和方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        //调用方法
        Method show = clazz.getMethod("show");
        show.invoke(p);
        System.out.println("*************************************");

        //通过反射，可以调用Person类的私有的结构，如私有构造器、方法、属性
        Constructor<Person> dCons = clazz.getDeclaredConstructor(String.class);
        dCons.setAccessible(true);
        Object obj1 = dCons.newInstance("Jerry");
        Person p1 = (Person) obj1;
        System.out.println(p1.toString());

        System.out.println("*************************************");

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Armi");
        System.out.println(p1.toString());

        System.out.println("*************************************");

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国");
        System.out.println(nation);

        System.out.println("*************************************");
    }
}
