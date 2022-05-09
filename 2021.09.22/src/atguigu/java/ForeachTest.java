package atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合、数组
 *
 *
 * @author lixhui
 * @create 2021-09-14:09
 */
public class ForeachTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();//ArrayList()是有序集合
//        add(object e);
        coll.add(123);//自动包装
        coll.add(new String("helloworld"));
        coll.add(false);
        coll.add(new String("atguigu"));
        Person p = new Person("lidatuo", 22);
        coll.add(p);

//        for(集合元素的类型 局部变量 ：集合对象)
//        内部仍然调用了迭代器
        for(Object obj : coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] ints = {1,2,3,4,5};
        for (int i : ints){
            System.out.println(i);
        }
    }

//    试题
    @Test
    public void test3(){
        String[] arrs = new String[]{"MM","MM","MM","MM","MM"};
        //方式一：普通for循环
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = "SS";
        }

        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
        System.out.println("*******************************");
        //方式二：增强for循环
        for (String s : arrs){
            s = "GG";
        }

        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
    }

}
