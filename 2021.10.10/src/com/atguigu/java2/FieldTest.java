package com.atguigu.java2;

import com.atguigu.java4.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author lixhui
 * @create 2021-10-18:38
 */
public class FieldTest {
    @Test
    public void test1(){
        Class clazz = Person.class;

        ////获取当前运行时类的所有公共属性（包括父类）
        Field[] fields = clazz.getFields();
//        System.out.println(fields);//[Ljava.lang.reflect.Field;@2b05039f
        for (Field f1 : fields){
            System.out.println(f1);
        }
        System.out.println("******************************");

        //获取当前运行时类的所有属性（不包括父类）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");
            //2.数据类型
            Class type = f.getType();
            System.out.print(type + "\t");
            //3.变量名
            String name = f.getName();
            System.out.print(name + "\t");

            System.out.println();
        }
    }

}
