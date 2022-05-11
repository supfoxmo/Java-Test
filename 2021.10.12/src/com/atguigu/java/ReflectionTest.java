package com.atguigu.java;

import com.atguigu.java4.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lixhui
 * @create 2021-10-9:21
 *
 * 调用运行时类的指定结构：属性、方法、构造器
 */
public class ReflectionTest {
    //
    @Test
    public void testField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person person = clazz.newInstance();
        //获取指定的属性: 要求运行时类的属性声明为public
        Field id = clazz.getField("id");
        //设置当前属性的值
        id.set(person,1002);
        //获取当前属性的值
        Object o = id.get(person);
        int id1 = (int) o;

        System.out.println(id1);

    }

    @Test
    public void testField1() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        //1.获取指定的运行时类的实例
        Class<Person> clazz = Person.class;

        //2.创建运行时类的对象
        Person person = clazz.newInstance();
        //3.获取指定的属性:
        Field name = clazz.getDeclaredField("name");
        //4.保证当前属性是可访问的
        name.setAccessible(true);
        //5.设置当前属性的值
        name.set(person,"Tem");
        //6.获取当前属性的值
        Object o = name.get(person);
        String name1 = (String) o;

        System.out.println(name1);

    }

    @Test
    public void testMethod() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1.获取指定的运行时类的实例
        Class<Person> clazz = Person.class;

        //2.创建运行时类的对象
        Person person = clazz.newInstance();

        //3.获取指定的方法
        Method show = clazz.getDeclaredMethod("show", String.class);

        //5.保证指定方法是可访问的
        show.setAccessible(true);

        //6.调用指定的方法
        //invoke()：参数1：方法的调用者   参数2：指明获取的方法的形参列表
        //invoke()的返回值即为对应类中调用的方法的返回值
        Object o = show.invoke(person, "中国");
        String nation = (String) o;

        System.out.println(nation);

        System.out.println("******************如何调用静态方法******************");

        Method showdecs = clazz.getDeclaredMethod("showdecs");

        showdecs.setAccessible(true);

        //如果调用的运行时类的方法没有返回值，则此invoke()返回null

        Object returnValue = showdecs.invoke(Person.class);
//        Object returnValue = showdecs.invoke(null);


        System.out.println(returnValue);//null


    }

    @Test
    public void testConstructor() throws Exception {
        Class<Person> clazz = Person.class;

        Constructor<Person> constructor = clazz.getConstructor(String.class);

        constructor.setAccessible(true);

        Person person = constructor.newInstance("Tom");

        System.out.println(person);


    }
}
