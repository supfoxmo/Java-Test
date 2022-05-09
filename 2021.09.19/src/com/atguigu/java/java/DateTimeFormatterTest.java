package com.atguigu.java.java;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author lixhui
 * @create 2021-09-11:30
 */
public class DateTimeFormatterTest {
    @Test
    public void test(){
//        实例化：
//        方式一：预定义的标准格式。如ISO_LOCAL_DATE_TIME；ISO_LOCAL_DATE；ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
//        格式化：日期-->字符串
        String datetimeformat = formatter.format(localDateTime);
        System.out.println(localDateTime);//2021-09-20T21:31:51.457
        System.out.println(datetimeformat);//2021-09-20T11:43:57.581
//        解析：字符串-->日期
        TemporalAccessor datetimeparse = formatter.parse(datetimeformat);
        System.out.println(datetimeparse);//{},ISO resolved to 2021-09-20T11:43:57.581

        System.out.println("******************************");
//        方式二：
//        1、本地化相关的格式。如：oflocalizedDateTime()
//        参数：FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT
//        适用于：LocalDateTime

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String format1 = dateTimeFormatter1.format(localDateTime);
        System.out.println(format1);//2021年9月20日 上午11时56分35秒
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String format2 = dateTimeFormatter2.format(localDateTime);
        System.out.println(format2);//2021-9-20 11:56:35
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String format3 = dateTimeFormatter3.format(localDateTime);
        System.out.println(format3);//21-9-20 上午11:56

//        2、本地化相关的格式。如：oflocalizedDate()
//        参数：FormatStyle.FULL/FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT
//        适用于：LocalDate

//        3、本地化相关的格式。如：oflocalizedTime()
//        适用于：LocalTime

        System.out.println("************************************");
//        重点：方式三：自定义格式。如ofPattern("yyyy-MM-dd hh.mm.ss)
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh.mm.ss");
//        格式化：
        String format4 = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format4);//2021-09-20 12.11.03
//        解析：
        TemporalAccessor parse = dateTimeFormatter.parse(format4);
        System.out.println(parse);//{NanoOfSecond=0, MilliOfSecond=0, MinuteOfHour=11, SecondOfMinute=3, MicroOfSecond=0, HourOfAmPm=0},ISO resolved to 2021-09-20

    }
}
