package com.atguigu.java.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lixhui
 * @create 2021-09-13:26
 */
public class SimpleDateFormatTest {
    @Test
    public void testsimpledateformat() throws ParseException {
        java.sql.Date sdate = new java.sql.Date(2021-9-20);
        System.out.println(sdate);


        SimpleDateFormat sdf1 = new SimpleDateFormat();
        //格式化：日期-->字符串
        Date date = new Date();
        String str = sdf1.format(date);
        System.out.println(str);

        //解析：格式化的逆过程，字符串-->日期
        Date date2 = sdf1.parse(str);//默认格式：21-9-19 下午1:46，否则抛异常
        System.out.println(date2);

        System.out.println("****************************");

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String format = sdf2.format(date2);
        System.out.println(format);

        Date parse = sdf2.parse("2021-09-19 13:54:30");
        System.out.println(parse);

    }
}




