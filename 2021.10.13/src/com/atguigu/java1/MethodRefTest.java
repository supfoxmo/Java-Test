package com.atguigu.java1;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lixhui
 * @create 2021-10-9:13
 * <p>
 * <p>
 * 方法引用的使用：
 * 1.使用情景：当要传递给lambda体的操作，已经由实现的方法了，可以使用方法引用。
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。
 * 所以方法引用，也是函数式接口的实例。
 * <p>
 * 3.使用格式：类（或对象） :: 方法名
 * 4.具体分为如下三种情况：
 * 情况一：    对象 :: 非静态方法
 * 情况二：    类 :: 静态方法
 * <p>
 * 情况三：    类 :: 非静态方法
 * <p>
 * 5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与
 * 方法引用的方法的形参列表和返回值类型相同（针对情况一和情况二）。
 */
public class MethodRefTest {
    //    情况一：    对象::非静态方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1() {
        Consumer<String> cons1 = s -> System.out.println(s);
        cons1.accept("北京欢迎你！");

        System.out.println("*******************************");
        PrintStream printStream = System.out;
        Consumer<String> cons2 = printStream::println;
        cons2.accept("广州是一座历史悠久的城市！");
    }

    //Supplier中的 T get()
    //Employee中的String getName()
    @Test
    public void test2() {
        Employee employee = new Employee(1001, "Tom", 26, 7800);

        Supplier<String> sup1 = () -> employee.getName();
        System.out.println(sup1.get());

        System.out.println("*******************************");
        Supplier<String> sup2 = employee::getName;
        System.out.println(sup2.get());
    }

    //    情况二：    类::静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3() {
        Comparator<Integer> comp1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comp1.compare(23, 19));

        System.out.println("*******************************");

        Comparator<Integer> comp2 = Integer::compare;
        System.out.println(comp2.compare(25, 47));
    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4() {
        Function<Double, Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(3.14156));

        System.out.println("*******************************");

        Function<Double, Long> func2 = Math::round;
        System.out.println(func2.apply(1.78329));
    }

    //    情况三：    类::非静态方法
    //Comparator中的int compare(T t1,T t2)
    //String中的int t1.compareTo(t2)
    @Test
    public void test5() {
        Comparator<String> com1 = (t1, t2) -> t1.compareTo(t2);
        System.out.println(com1.compare("abc", "dfg"));

        System.out.println("*******************************");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com1.compare("acb", "abc"));
    }

    //BiPredicate中的boolean test(T t1,T t2);
    //String中的boolean t1.equals(t2);
    @Test
    public void test6() {
        BiPredicate<String, String> bip1 = (t1, t2) -> t1.equals(t2);
        System.out.println(bip1.test("guangzhou", "guangzhou"));

        System.out.println("*******************************");

        BiPredicate<String, String> bip2 = String::equals;
        System.out.println(bip2.test("Tom", "Jerry"));
    }

    //Function中的R apply(T t)
    //Employee中的String getName()
    @Test
    public void test7() {
        Employee employee = new Employee(1010, "Jerry", 25, 5600);

        Function<Employee, String> func1 = e -> e.getName();
        System.out.println(func1.apply(employee));

        System.out.println("*******************************");

        Employee employee1 = new Employee(1011, "Mary", 22, 5000);

        Function<Employee, String> func2 = Employee::getName;
        System.out.println(func2.apply(employee1));
    }


}
