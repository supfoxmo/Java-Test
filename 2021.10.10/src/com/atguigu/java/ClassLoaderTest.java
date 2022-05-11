package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author lixhui
 * @create 2021-10-22:23
 */
public class ClassLoaderTest {
//    了解类的加载器
    @Test
    public void test(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader1);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //调用系统类加载器的getParent():获取扩展类加载器
        ClassLoader classloader2 = classLoader1.getParent();
        System.out.println(classloader2);//sun.misc.Launcher$ExtClassLoader@28a418fc

        //调用扩展来加载器的getParent():无法获取引导类加载器
        //引导类加载器主要负责加载Java的核心类库，无法加载自定义类
        ClassLoader classloader3 = classloader2.getParent();
        System.out.println(classloader3);//null

        //String为Java的核心类库
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);//null
    }

    @Test
    public void test1() throws IOException {
        Properties pros = new Properties();
        //此时的文件默认在当前的module下
        //读取配置文件的方式一：
        FileInputStream fis = new FileInputStream(new File("jdbc.properties"));
        pros.load(fis);

        String name = pros.getProperty("name");
        String age = pros.getProperty("age");
        String id = pros.getProperty("id");
        System.out.println("name = " + name + "\nage = " + age + "\nid = " + id);

        System.out.println("*********************************");
        //读取配置文件的方式二：使用Classloader
        //读取文件默认识别为：当前module的src下
        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader1.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String name1 = pros.getProperty("name");
        String age1 = pros.getProperty("age");
        String id1 = pros.getProperty("id");
        System.out.println("name = " + name1 + "\nage = " + age1 + "\nid = " + id1);

    }
}
