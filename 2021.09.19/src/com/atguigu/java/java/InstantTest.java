package com.atguigu.java.java;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author lixhui
 * @create 2021-09-11:08
 */
public class InstantTest {
    @Test
    public void test(){
//      实例化
//      方式一：now():
        Instant instant = Instant.now();//默认本初子午线的标准时间
        System.out.println(instant);//2021-09-20T03:12:32.378Z

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2021-09-20T11:16:29.421+08:00

        long toEpochMilli = instant.toEpochMilli();
        System.out.println(toEpochMilli);//获取从1970年1月1日00:00:00的毫秒数

//      方式二：ofEpochMilli():通过给定的毫秒数，获取Instant实例 -->类似于 Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1234679266478l);
        System.out.println(instant1);


    }
}
