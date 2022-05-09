package atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author lixhui
 * @create 2021-09-13:18
 */
public class IteratorTest {
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

        Iterator iterator = coll.iterator();//iterator为迭代器，用于遍历集合，可以想象成一个指向集合头部上一位置的指针
//         方式一：next()：①指针下移   ②将下移以后指向的集合位置是的元素返回
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        方式二：
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }
//        方式三：hasNext()：判断指针iterator是否还有下一元素
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        System.out.println("*********************************");

        System.out.println(coll);
    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();//ArrayList()是有序集合
//        add(object e);
        coll.add(123);//自动包装
        coll.add(new String("helloworld"));
        coll.add(false);
        coll.add(new String("atguigu"));
        Person p = new Person("lidatuo", 22);
        coll.add(p);

        Iterator iterator = coll.iterator();//iterator为迭代器，用于遍历集合，可以想象成一个指向集合头部上一位置的指针

//        Iterator迭代器中的remove():
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if (new String("helloworld").equals(obj)){
                iterator.remove();
            }
        }

        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
