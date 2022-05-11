package com.atguigu.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lixhui
 * @create 2021-10-10:38
 */
public class ConstructorRefTest {
    //构造器引用
    @Test
    public void test1() {
        Supplier<Employee> sup1 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        Employee employee1 = sup1.get();
        System.out.println(employee1);

        System.out.println("**************************");

        Supplier<Employee> sup2 = () -> new Employee();
        Employee employee2 = sup2.get();
        System.out.println(employee2);

        System.out.println("**************************");

        Supplier<Employee> sup3 = Employee :: new;
        Employee employee3 = sup3.get();
        System.out.println(employee3);

    }

    @Test
    public void test2() {
        Function<Integer, Employee> func1 = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer integer) {
                return new Employee(integer);
            }
        };
        Employee employee1 = func1.apply(1001);
        System.out.println(employee1);

        System.out.println("**************************");

        Function<Integer, Employee> func2 = i -> new Employee(i);
        Employee employee2 = func2.apply(1002);
        System.out.println(employee2);

        System.out.println("**************************");

        Function<Integer, Employee> func3 = Employee :: new;
        Employee employee3 = func3.apply(1003);
        System.out.println(employee3);
    }

    @Test
    public void test3() {
        BiFunction<Integer, String, Employee> bfunc1 = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer integer, String str) {
                return new Employee(integer, str);
            }
        };
        Employee employee1 = bfunc1.apply(1001, "Tom");
        System.out.println(employee1);

        System.out.println("**************************");

        BiFunction<Integer, String, Employee> bfunc2 = (i, s) -> new Employee(i, s);
        Employee employee2 = bfunc2.apply(1002, "Jerry");
        System.out.println(employee2);

        System.out.println("**************************");

        BiFunction<Integer, String, Employee> bfunc3 = Employee :: new;
        Employee employee3 = bfunc3.apply(1003, "Mark");
        System.out.println(employee3);
    }

    //数组引用
    @Test
    public void test4(){
        Function<Integer,String[]> func1 = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer.intValue()];
            }
        };
        String[] arr1 = func1.apply(3);
        System.out.println(Arrays.toString(arr1));

        System.out.println("******************************");

        Function<Integer,String[]> func2 = i -> new String[i];
        String[] arr2 = func2.apply(5);
        System.out.println(Arrays.toString(arr2));

        System.out.println("******************************");

        Function<Integer,String[]> func3 = String[] :: new;
        String[] arr3 = func3.apply(10);
        System.out.println(Arrays.toString(arr3));

    }

}
