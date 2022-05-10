package com.atguigu.java.java;

import org.junit.Test;

import java.util.*;

/**
 * @author lixhui
 * @create 2021-09-14:05
 */
public class MapTest {
    @Test
    public void test1(){
        HashMap hashMap = new HashMap();
        //添加
        hashMap.put("linshaohua",23);
        hashMap.put("guofucheng",55);
        hashMap.put("machao",20);
        hashMap.put("zhaoyun",20);
        System.out.println(hashMap);
        System.out.println("***************************");
        //修改
        hashMap.put("guofucheng",57);
        System.out.println(hashMap);
        System.out.println("***************************");
        //移除
        Object value = hashMap.remove("linshaohua");
        System.out.println(value);
        Object value1 = hashMap.remove("linshaohua-2");
        System.out.println(value1);
        System.out.println(hashMap);
        System.out.println("***************************");
        //clear():清空
        hashMap.clear();
        System.out.println(hashMap.size());
        System.out.println(hashMap);
    }

    @Test
    public void test2(){
        HashMap hashMap = new HashMap();
        //添加
        hashMap.put("linshaohua",23);
        hashMap.put("guofucheng",55);
        hashMap.put("machao",20);
        hashMap.put("zhaoyun",20);
        System.out.println(hashMap);
        System.out.println("***************************");
        //get(Object key):查询，获取指定key对应的values
        Object o = hashMap.get("zhaoyun");
        System.out.println(o);
        System.out.println("***************************");
        //containsKey(Object key)
        boolean isExist = hashMap.containsKey("machao");
        System.out.println(isExist);
        boolean isExist1 = hashMap.containsKey("caocao");
        System.out.println(isExist1);
         System.out.println("***************************");
        //containsValue(Object value)
        boolean isExist2 = hashMap.containsValue(20);
        System.out.println(isExist2);
        boolean isExist3 = hashMap.containsValue(25);
        System.out.println(isExist3);
        System.out.println("***************************");
        //isEmpty()
        hashMap.clear();
        System.out.println(hashMap.isEmpty());
        System.out.println("***************************");
        //equals()
        HashMap hashMap1 = new HashMap();

        hashMap1.put("wangzhaojun",18);
        hashMap1.put("yasewang",27);
        hashMap1.put("gaiye",88);

        boolean result = hashMap.equals(hashMap1);
        System.out.println(result);


    }

    @Test
    public void test3(){
        HashMap hashMap = new HashMap();
        //添加
        hashMap.put("linshaohua",23);
        hashMap.put("guofucheng",55);
        hashMap.put("machao",20);
        hashMap.put("zhaoyun",20);
        System.out.println(hashMap);
        System.out.println("***************************");
        //Set keySet():返回所有key构成的Set集合
        //遍历所有key构成的Set集合
        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("***************************");
        //Collection values():返回所有的values构成的Collection集合
        //遍历所有的values构成的Collection集合
        Collection values = hashMap.values();
        for (Object obj : values){
            System.out.println(obj);
        }

        System.out.println("***************************");
        //Set entrySet():返回所有key-values对构成的Set集合
        //方式一：遍历所有的key-values
        Set set1 = hashMap.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object obj1 = iterator1.next();
            Map.Entry entry = (Map.Entry) obj1;
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }

        //方式二：遍历所有的key-values
        System.out.println("***************************");
        Set set2 = hashMap.keySet();
        Iterator iterator3 = set.iterator();
        while(iterator3.hasNext()){
            Object key = iterator3.next();
            System.out.println(key + "===" + hashMap.get(key));
        }

    }


}
