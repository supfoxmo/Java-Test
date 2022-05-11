package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author lixhui
 * @create 2021-10-14:18
 *
 * java内置的4大核心函数式接口：
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T y)
 * 断定型接口 Predicate<T>    boolean test(T t)
 *
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为" + aDouble);
            }
        });

        System.out.println("****************************");

        happyTime(50,money -> System.out.println("动物园的门票价格为：" + money));
    }



    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }


    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京", "天津", "西京", "东京", "美金", "南京", "普京");

        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filterString);
    }

    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> list1 = new ArrayList<>();

        for (String s : list){
            if (pre.test(s)){
                list1.add(s);
            }
        }

        return list1;
    }

}
