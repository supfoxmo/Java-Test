package com.atguigu.java.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lixhui
 * @create 2021-09-14:03
 */
public class SqlDateTest {
    //字符串-->java.sql.Date
    @Test
    public void Test1() throws ParseException {
//        java.sql.Date的两种实例化方式
        java.sql.Date sdate1 = new java.sql.Date(123245435654l);//距离1970年1月1日0:00 的毫秒数
        System.out.println(sdate1);
        java.sql.Date sdate2 = new java.sql.Date(2021 - 9 - 20);//格式必须相同  yyyy-MM-dd
        System.out.println(sdate2);

        System.out.println("*****************************");
        String str = "2021.09.19";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

//      解析：字符串-->sql.date
        Date date = sdf.parse(str);
        java.sql.Date sdate3 = new java.sql.Date(date.getTime());
        System.out.println(sdate3);//sql.date
//      格式化：sql.date-->字符串
        String str1 = sdf.format(sdate3);
        System.out.println(str1);//字符串


    }
}
