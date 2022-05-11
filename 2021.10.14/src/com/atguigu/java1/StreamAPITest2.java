package com.atguigu.java1;

import com.atguigu.java.Employee;
import com.atguigu.java.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lixhui
 * @create 2021-10-8:12
 *
 * Stream的终止操作：
 */
public class StreamAPITest2 {
    //1.查找与匹配
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch(Predicate p):检查是否匹配所有元素。练习：是否所有员工的年龄都大于18
        boolean ageAllMatch = employees.stream().allMatch(employee -> employee.getAge() > 18);
        System.out.println(ageAllMatch);
        System.out.println("***************************************************************");

        //anyMatch(Predicate p):检查是否至少匹配一个元素。练习：是否存在员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(employee -> employee.getSalary() > 10000);
        System.out.println(anyMatch);
        System.out.println("***************************************************************");

        //noneMatch(Predicate p):检查是否没有匹配的元素。练习：是否存在员工姓“雷”
        boolean noneMatch = employees.stream().noneMatch(employee -> employee.getName().startsWith("雷"));
        System.out.println(noneMatch);
        System.out.println("***************************************************************");

        //findFirst():返回第一个元素
        Stream<Employee> stream = employees.stream().sorted((e1, e2) -> {
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0) {
                return ageValue;
            } else {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        });
        System.out.println(stream.findFirst());
        System.out.println("***************************************************************");

        //findAny():返回当前流中任意一个元素
        System.out.println(employees.stream().findAny());
        System.out.println(employees.parallelStream().findAny());
        System.out.println("***************************************************************");

        //count():返回流中元素的总个数
        long count = employees.stream().count();
        System.out.println(count);
        System.out.println("***************************************************************");

        //max(Comparator c):返回流中最大值。练习：返回最低工资
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max((d1, d2) -> Double.compare(d1, d2));
        System.out.println(maxSalary);
        System.out.println("***************************************************************");

        //min(Comparator c):返回流中最小值。练习：返回最低工资的员工
        Optional<Employee> minSalaryEmployee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(minSalaryEmployee);
        System.out.println("***************************************************************");

        //forEach(Comsumer c):内部迭代
        employees.stream().forEach(System.out::println);//此时的 forEach()作为一个流的终止操作
        System.out.println("***************************************************************");

        employees.forEach(System.out::println);//此时的 forEach()作为一个集合的普通遍历方法


    }

    //2.归约
    @Test
    public void test2(){
        //reduce(T identity,BinaryOperator b):可以将流中元素反复结合起来，得到一个值。返回T
        //练习：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4,1,5,7,4, 5, 6, 7, 8, 9, 10);

        Integer sum = list.stream().reduce(0, Integer::sum);//identity：初始值
        System.out.println(sum);
        //reduce(BinaryOperator b):可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        //练习：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();

        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> sumSalary = salaryStream.reduce(Double::sum);
        System.out.println(sumSalary);

        Stream<Integer> distinct = list.stream().distinct();

        distinct.forEach(System.out::println);

    }

    //3.收集
    @Test
    public void test3(){
        //Collect(Collector c):将流转化为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        //Collector接口中方法的实现决定了如何对流执行收集的操作（如收集到List、Set、Map）。
        //练习：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();

        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);

        System.out.println("************************************");

        Set<Employee> employeeList1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeList1.forEach(System.out::println);
    }

}
