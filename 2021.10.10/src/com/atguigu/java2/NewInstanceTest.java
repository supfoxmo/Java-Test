package com.atguigu.java2;

import org.junit.Test;

import java.util.Random;

/**
 * @author lixhui
 * @create 2021-10-13:31
 */
public class NewInstanceTest {
    @Test
    //体会反射的动态性
    public void test1(){
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";

            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.atguigu.java.Person";
                    break;
            }

            try {
                Object instance = getInstance(classPath);
                System.out.println(instance);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        //创建并返回运行类的对象
        return clazz.newInstance();
    }


}
