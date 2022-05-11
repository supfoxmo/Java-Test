package com.atguigu.java2;

import com.atguigu.java4.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author lixhui
 * @create 2021-10-19:57
 */
public class OtherTest {
    //构造器
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;

        //获取当前运行时类的所有公共构造器（不包括父类）
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println("*********************************************");

        //获取当前运行时类的所有构造器（不包括父类）
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor dc : declaredConstructors) {
            System.out.println(dc);
        }
    }

    //获取当前运行时类的父类
    @Test
    public void test2() {
        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();

        System.out.println(superclass);//class com.atguigu.java1.Creature
    }

    //获取当前运行时类带泛型的父类
    @Test
    public void test3() {
        Class clazz = Person.class;

        Type superGenericclass = clazz.getGenericSuperclass();

        System.out.println(superGenericclass);//class com.atguigu.java1.Creature
    }

    //获取当前运行时类带泛型的父类的泛型
    @Test
    public void test4() {
        Class clazz = Person.class;

        Type superGenericclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType)superGenericclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        for (Type a : actualTypeArguments){
            System.out.println(a.getTypeName());//java.lang.String
            //或
            System.out.println(((Class)a).getName());//java.lang.String

        }

    }

    //获取运行时类的接口(不包括父类实现的接口)
    @Test
    public void test5(){
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();

        for (Class i : interfaces){
            System.out.println(i);
            /*
                interface java.lang.Comparable
                interface com.atguigu.java1.MyInterface
             */
        }
        System.out.println("*********************************************");


        //获取当前运行时类的父类实现的接口
        Class<? super Person> superclass = clazz.getSuperclass();
        Class<?>[] superclassInterfaces = superclass.getInterfaces();

        for (Class si : superclassInterfaces){
            System.out.println(si);
            /*
                interface java.io.Serializable
             */
        }

    }

    //获取当前运行时类所在的包
    @Test
    public void Test6(){
        Class<Person> clazz = Person.class;

        Package aPackage = clazz.getPackage();

        System.out.println(aPackage);//package com.atguigu.java1
    }

    //获取当前运行时类所在的包
    @Test
    public void Test7(){
        Class<Person> clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annos : annotations){
            System.out.println(annos);//@com.atguigu.java1.MyAnnotation(value=hi)
        }
    }
}