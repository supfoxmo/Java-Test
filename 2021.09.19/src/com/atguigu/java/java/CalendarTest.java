package com.atguigu.java.java;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author lixhui
 * @create 2021-09-14:33
 */
public class CalendarTest {
    @Test
    public void Test1() {
//        1、实例化
//        方式一：创建其子类(GregorianCalendar)的对象
//        方式二：调用静态方法getInstance();
        Calendar calendar = Calendar.getInstance();//相当于创建其子类(GregorianCalendar)的对象

        //常见方法
        //get()
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 25);
        int month = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_YEAR, 70);
        int year = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_WEEK, 3);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(year + "-" + month + "-" + week);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        month = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DAY_OF_YEAR, 14);
        year = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.add(Calendar.DAY_OF_WEEK, 4);
        week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(year + "-" + month + "-" + week);



        //gettime()
        Date date = calendar.getTime();
        System.out.println(date);

        //settime()
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
