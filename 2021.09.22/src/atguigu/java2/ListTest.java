package atguigu.java2;


import atguigu.java.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lixhui
 * @create 2021-09-20:44
 */
public class ListTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);        
        list.add("bibido");
        list.add(new Person("tangsan",24));
        list.add(false);
        list.add(123);
        list.add(new Person("xiaowu",21));

        System.out.println(list);

//        1、void add(int index,Object ele):在角标为index位置插入ele元素
        list.add(2,"huntiandi");
        System.out.println(list);
        System.out.println("*********************************************************************");
//        2、boolean addAll(int index,Collection eles):从index位置开始将eles中的所有元素添加到当前集合中
        List<Integer> list1 = Arrays.asList(110, 119, 120);
        list.addAll(3,list1);
        System.out.println(list);
        System.out.println("当前集合中元素的个数：" + list.size());
    }

    @Test
    public void tset2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("bibido");
        list.add(new Person("tangsan",24));
        list.add(false);
        list.add(123);
        list.add(new Person("xiaowu",21));

        System.out.println(list);
//        3、int indexof(Object obj):返回obj在集合首次出现的位置
        int index = list.indexOf(123);
        System.out.println(index);
//        4、int lastindexof(Object obj):返回obj在集合末次出现的位置
        int index1 = list.lastIndexOf(123);
        System.out.println(index1);
        System.out.println("*****************************");
//        5\Object remove(int index):移除指定index位置的元素，并返回此元素
//        注意：与void remove(Object obj)区分开
        Object remove = list.remove(3);
        System.out.println("移除的元素为：" + remove);
        System.out.println(list);
        System.out.println("*****************************");
//        6、Object set(int index,Object ele):设定指定index位置的元素为ele
        list.set(2,new Person("zhuzhuqing",27));
        System.out.println(list);
        System.out.println("*****************************");
//        7、List subList(int fromIndex,int toIndex)：返回从fromIndex到toIndex位置的左闭右开区间的元素
        List list1 = list.subList(2, 5);
        System.out.println(list1);


    }

    @Test
    public void test2(){
        int[] arr = new int[5];
        arr[3] = 3;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
