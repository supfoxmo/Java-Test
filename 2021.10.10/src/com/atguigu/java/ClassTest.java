package com.atguigu.java;

import org.junit.Test;

/**
 * @author lixhui
 * @create 2021-10-21:28
 *
 * 关于java.lang.Class类的理解
 * 1.类的加载过程：
 *  程序经过使用javac.exe命令以后，会生成一个或多个字节码文件（.class结尾）。
 *  接着我们使用java.exe命令对某一个字节码文件进行解释运行。相当于将某各字节码文件
 *  加载到内存中。此过程就称为类的加载。加载到内存中的类，就称为运行时类，此运行时类。
 *  就作为Class的一个实例。
 *
 * 2.换句话说，Class的实例就是对应着一个运行时类。
 * 3.加载到内存中的运行时类，会缓存一定的时间。再次时间之内，可以通过不同的方式来获取此运行时类
 */
public class ClassTest {
    @Test
    //获取Class的实例的方法（前三种方式需要掌握）
    public void test() throws ClassNotFoundException {
        //方式一：调用运行时类的属性： .class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：调用运行时类的对象，调用getClass()
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);
        //方式四：使用类的加载器：ClassLoader （了解）
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clazz4);
    }

    @Test
    //只要数组元素类型与维度一样，就是同一个Class
    public void test1(){
        int[] a = new int[10];
        int[] b = new int[100];
        int[][] ints = new int[10][];
        String[] strings = new String[10];
        Class c10 = a.getClass();
        Class c100 = b.getClass();
        Class c = ints.getClass();
        Class stringsClass = strings.getClass();

        System.out.println(c10 == c100);
        System.out.println(c == c10);
        System.out.println(stringsClass == c10);
    }

}
