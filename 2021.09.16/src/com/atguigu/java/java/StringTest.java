package com.atguigu.java.java;

import org.junit.Test;

/**
 * @author lixhui
 * @create 2021-09-13:33
 */
public class StringTest {

    /*
     *String:字符串
     * 1、String声明为final的，不可被继承
     * 2、String实现了Serializable接口：表示字符串是自持序列化的
     *          实现了Conmparable接口；表示String可以比较大小
     * 3、String内部定义了final char[] value用于存储字符串数据
     * 4、String：代表不可变的字符序列。简称：不可变性
     *      体现一：当对字符串重新赋值时，需要重新指定内存区域赋值，不能使用原有的value进行赋值
     * 5、通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
     * 6、字符串常量池是不会存储相同内容的字符串的
     */
    @Test
    public void test1(){
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";

        System.out.println("s1 = " + s1 + "\n" + "s2 = " + s2);
        System.out.println(s1 == s2);//比较地址

        s1 = "Hello";
        System.out.println("s1 = " + s1 + "\n" + "s2 = " + s2);
        System.out.println(s1 == s2);//比较地址

        System.out.println("*****************************");
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);
        System.out.println(s2);

        System.out.println("*****************************");
        String s4 = "abac";
        String s5 = s4.replace('a', 'd');
        System.out.println(s4);
        System.out.println(s5);

    }

    @Test
    public void test2(){
        /*
         * 1、常量与常量的拼接结果在常量。且常量池中不会存在相同的内容的常量
         * 2、只要其中有一个变量，结果就在堆中
         * 3、如果拼接的结果调用intern()方法，返回值就在常量池中
         */
        String s1 = "JavaEE";
        String s2 = "JavaEE";
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false
    }

    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = s5.intern();//返回值得到的s8使用的常量值中已经存在的"javaEEhadoop"
        System.out.println(s3 == s8);//true
    }

    @Test
    public void test4(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);//false

        final String s4 = "javaEE";//常量在常量池中
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);//true
    }

}
