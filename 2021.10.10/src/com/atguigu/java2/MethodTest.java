package com.atguigu.java2;

import com.atguigu.java4.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author lixhui
 * @create 2021-10-18:57
 */
public class MethodTest {
    @Test
    public void test1() {
        Class clazz = Person.class;

        //获取当前运行时类及其父类所有公共方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("**************************************************");

        //获取当前运行时类中声明的所有方法（不包括其父类声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

    }

    /*
     *@Xxxxxx
     * 权限修饰符  返回值类型  方法名（参数类型1  形参名1，.....）throws XxxException{}
     */
    @Test
    public void test2() {
        Class clazz = Person.class;

        Method[] methods = clazz.getDeclaredMethods();

        for (Method m : methods) {
            //注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation anno : annotations) {
                System.out.println(anno);
            }

            //权限修饰符
            int modifiers = m.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //返回值类型
            Class returnType = m.getReturnType();
            System.out.print(returnType + "\t");

            //方法名
            String name = m.getName();
            System.out.print(name);

            System.out.print("(");
            //参数列表
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null || parameterTypes.length == 0)){

                for (int i = 0;i < parameterTypes.length;i++){
                    if (i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + "  args_" + i);

                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "  args_" + i + ",");
                }
            }
            System.out.print(")");

            //抛异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (!(exceptionTypes == null || exceptionTypes.length == 0)){
                System.out.print("throws ");
                for (int i = 0;i < exceptionTypes.length;i++){
                    if (i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());

                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();
        }
    }
}