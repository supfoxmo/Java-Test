package atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author lixhui
 * @create 2021-09-16:34
 */
public class CollcetionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
//        1、add(object e);
        coll.add(123);//自动包装
        coll.add(new String("helloworld"));
        coll.add(false);
        Person p = new Person("lidatuo", 22);
        coll.add(p);

        Collection coll2 = new ArrayList();
        coll2.add(936);
        coll2.add(true);
        coll2.add(new Person("chengodan",18));

//        1.1、addAll()
        coll.add(coll2);//[936, true, Person{name='chengodan', age=18}]
        System.out.println(coll.size());

        coll.addAll(coll2);//936, true, Person{name='chengodan', age=18}
        System.out.println(coll.size());

        coll.addAll(Arrays.asList(123,"mutouren"));//123, mutouren
        System.out.println(coll.size());

        System.out.println(coll);

        System.out.println("*************************");
//        2、contains(Object obj); 判断当前集合中是否包含obj, 调用equals()从头到尾依次判断是否相等
        boolean contains = coll.contains(123);
        System.out.println(contains);//ture

        System.out.println(coll.contains(new String("helloworld")));//ture

        System.out.println(coll.contains(p));//ture
        System.out.println(coll.contains(new Person("lidatuo", 22)));//false,   Person类重写equals()后--> ture
        System.out.println("*************************");
//        3、containsAll(collection coll1):判断形参coll1中的所有元素是否都存在当前集合中
        Collection coll1 = Arrays.asList(123,false);
        System.out.println(coll.containsAll(coll1));//ture
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
//        add(object e);
        coll.add(123);//自动包装
        coll.add(new String("helloworld"));
        coll.add(false);
        coll.add(new String("atguigu"));
        Person p = new Person("lidatuo", 22);
        coll.add(p);

//        4、remove(Object obj);从当前集合中移除obj元素
        boolean remove1 = coll.remove(123);
        System.out.println(remove1);//ture
        boolean remove2 = coll.remove(new Person("lidatuo", 22));
        System.out.println(remove2);//ture

        System.out.println(coll);
        System.out.println("***************************");
//        5、removeAll(Collectinon coll1):从当前集合中移除coll1中所有的元素--->差集
        Collection coll1 = Arrays.asList(123,456,"atguigu");
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();//ArrayList()是有序集合
//        add(object e);
        coll.add(123);//自动包装
        coll.add(new String("helloworld"));
        coll.add(false);
        coll.add(new String("atguigu"));
        Person p = new Person("lidatuo", 22);
        coll.add(p);

//        6、retainAll(Collectinon coll1):从当前集合中移除和coll1中元素不同的元素--->交集
        Collection coll1 = Arrays.asList(123,456,"atguigu");
        System.out.println("原先集合：" + coll);
        coll.retainAll(coll1);
        System.out.println("求交集后：" + coll);
        System.out.println("******************************");
//        7、equals(Object obj):判断当前集合与形参集合元素是完全相同
        Collection coll2 = Arrays.asList(123,"atguigu");
        boolean result = coll.equals(coll2);
        System.out.println(result);//ture
        Collection coll3 = Arrays.asList("atguigu",123);
        boolean result1 = coll.equals(coll3);
        System.out.println(result1);//false
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();//ArrayList()是有序集合
//        add(object e);
        coll.add(123);//自动包装
        coll.add(new String("helloworld"));
        coll.add(false);
        coll.add(new String("atguigu"));
        Person p = new Person("lidatuo", 22);
        coll.add(p);

//        8、hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());
        System.out.println("******************************");
//        9、toArray():集合--->数组
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("******************************");

//        拓展：数组--->集合 ：调用Arrays类的静态方法asList()
        String[] arrs = new String[]{"new year","happy sunday","I love momo"};
        List list = Arrays.asList(arrs);
        System.out.println(list);//[new year, happy sunday, I love momo]

        List list1 = Arrays.asList(new int[]{123, 456});
        System.out.println(list1);//[[I@2b05039f]
        System.out.println(list1.size());//1
//      方式一：
        List list3 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(list3);//[123, 456]
        System.out.println(list3.size());//2
//      方式二：
        List list2 = Arrays.asList(123, 456);
        System.out.println(list2);//[123, 456]
        System.out.println(list2.size());//2


    }
}
