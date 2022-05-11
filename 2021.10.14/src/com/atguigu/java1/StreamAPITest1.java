package com.atguigu.java1;

import com.atguigu.java.Employee;
import com.atguigu.java.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lixhui
 * @create 2021-10-22:26
 */
public class StreamAPITest1 {
    //筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();

        Stream<Employee> stream = list.stream();
//        filter(Predicate p)--接收 Lambda，从流中排除某些元素
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out :: println);
        System.out.println("***********************************************");
//        limit(n)--截断流，使其元素不超过给定的数量
        list.stream().limit(3).forEach(System.out :: println);
        System.out.println("***********************************************");
//        skip(n)--跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流
        list.stream().skip(3).forEach(System.out :: println);
        System.out.println("***********************************************");
//        distinct()--筛选，通过流所生成的元素的hashCode()和epuals()去除重复的元素
        list.add(new Employee(1003,"刘强东",33,4580.90));


        list.stream().skip(2).distinct().forEach(System.out :: println);
        System.out.println("***********************************************");

    }

    //映射
    @Test
    public void test2(){
//        map(Function f)--接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
//        flatMap(Function f)--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流

    }

    //排序
    @Test
    public void test3(){
//        sorted()--自然排序
        List<Integer> list = Arrays.asList(29, 36, 16, 30, 57, 95, 82, 47, 50);
        list.stream().sorted().forEach(System.out :: println);

        System.out.println("**************************");
        //报异常，原因：Employee没有重写Comparable接口
        //List<Employee> list1 = EmployeeData.getEmployees();
        //list1.stream().sorted().forEach(System.out :: println);

//        sorted(Comparator com)--定制排序
        List<Employee> list1 = EmployeeData.getEmployees();
        list1.stream().sorted((e1,e2) -> {
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0){
                return ageValue;
            }else{
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);

    }

}
