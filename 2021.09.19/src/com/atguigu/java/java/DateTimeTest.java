package com.atguigu.java.java;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author lixhui
 * @create 2021-09-10:39
 */
public class DateTimeTest {
    @Test
    public void test1(){
//      实例化：1、now()
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

//      2、of()不会产生偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 9, 20, 10, 48, 30, 4500000);
        System.out.println(localDateTime1);
        System.out.println("************************");
//        get():
        System.out.println(localDateTime1.getDayOfYear());
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getDayOfWeek());
        System.out.println(localDateTime1.getMonthValue());
        System.out.println(localDateTime1.getYear());
        System.out.println(localDateTime1.getMonth());
        System.out.println("************************");
//        with-->改  (不可变性)
        LocalDateTime localDateTime2 = localDateTime.withDayOfYear(10);
        System.out.println(localDateTime2);
        System.out.println(localDateTime);
        System.out.println("************************");
//        plus-->加 (不可变性)
        LocalDateTime localDateTime3 = localDateTime.plusYears(2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime);
        System.out.println("************************");
//        minus-->减(不可变性)
        LocalDateTime localDateTime4 = localDateTime.minusDays(10);
        System.out.println(localDateTime4);
        System.out.println(localDateTime);




    }
}
