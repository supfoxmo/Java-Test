package com.atguigu.java1;

import com.atguigu.java.Employee;
import com.atguigu.java.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lixhui
 * @create 2021-10-13:14
 *
 *
 * 1.Stream关注的是对数据的运算，与CPU打交道
 *   集合关注的是数据的存储，与内存打交道
 * 2.
 * ①Stream 自己不会存储元素
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream.
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 * 3.Stream 执行操作
 * ①Stream 的实例化
 * ②一系列的中间操作（过滤，映射...)
 * ③终止操作
 * 4.说明：
 * 4.1 一个中间操作链，对数据源的数据进行处理
 * 4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会被使用
 */
public class StreamAPITest {
    //创建 Stream方法一：通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //default Stream<E> stream():返回一个顺序流
        Stream<Employee> stream = employees.stream();
        //default Stream<E> parallelStream():返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    //创建 Stream方法二：通过数组
    @Test
    public void tset2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //调用Arrays类的static <T> Stream<T> stream(T[] array):返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee employee1 = new Employee(1010, "周润发", 47, 3900);
        Employee employee2 = new Employee(1020, "泰森", 51, 6890);

        Employee[] employees = new Employee[]{employee1,employee2};
        Stream<Employee> stream1 = Arrays.stream(employees);

    }

    //创建Stream方式三：通过Stream的 of()
    @Test
    public void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);
    }

    //创建Stream方式四：创建无限流
    @Test
    public void test4(){
        //迭代
        //public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
        //遍历前十个偶数
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out :: println);

        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math :: random).limit(10).forEach(System.out :: println);
    }

    @Test
    public void test5(){
        Employee e = null;
        System.out.println(e.getSalary());
    }
}
