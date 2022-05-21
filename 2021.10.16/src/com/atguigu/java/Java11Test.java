package com.atguigu.java;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author lixhui
 * @create 2021-10-11:31
 */
public class Java11Test {
    @Test
    public void test(){
        //isBlank():判断字符串是否为空白
        System.out.println("     ".isBlank());
        System.out.println("   \t \t \n   ".isBlank());

        //strip():去除收尾空白
        System.out.println("---" + "   \t abc \t \n   ".strip() + "---");
        //相当与trim()方法
        System.out.println("---" + "   \t abc \t \n   ".trim() + "---");

        //stripTrailing():去除尾部空格
        System.out.println("---" + "   \t abc \t \n   ".stripTrailing() + "---");

        //stripLeading():去除首部空格
        System.out.println("---" + "   \t abc \t \n   ".stripLeading() + "---");

        //repeat(int count):复制字符串，count：复制的次数
        String str = "hello world!";
        System.out.println(str.repeat(5));

        //lines().count():行数统计
        String str1 = "jdwhf\ncagchjd\nbscah\n";
        long count = str1.lines().count();
        System.out.println(count);


    }

    @Test
    public void test1(){
        var o = Optional.empty();
        //java11
        System.out.println(o.isPresent());//判断内部的value是否存在
        System.out.println(o.isEmpty());//判断内部的value是否为空

        //java10
        //orElseThrow():value非空，返回value；否则抛异常
        o = Optional.of("abc");
        Object o1 = o.orElseThrow();
        System.out.println(o1);

        //java9
        //or():value非空，返回对应的Optional;value为空，则返回形参封装的Optional
        Optional<String> optional = Optional.of("hello");
        Optional<Object> or = o.or(() ->optional);
        System.out.println(or);

        o = Optional.empty();
        Optional<Object> or1 = o.or(() ->optional);
        System.out.println(or1);

        //java9
        //ifPresentOrElse():value非空，执行参数1功能;如果value为空，执行参数2功能
//        o.ifPresentOrElse();
    }

    //java11新特性：局部变量推断的升级
    @Test
    public void test2(){
        //错误 形式：必须要有类型，可以加上var
//        Consumer<String> con1 = (@Deprecated t) -> System.out.println(toString().toUpperCase());
        //正确形式：使用var的好处是在使用lambda表达式时给参数加注解。
        Consumer<String> con1 = (@Deprecated var t) -> System.out.println(t.toString().toUpperCase());

        String str = new String("abc");
        con1.accept(str);


    }


}
