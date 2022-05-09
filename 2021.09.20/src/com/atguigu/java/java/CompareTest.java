package com.atguigu.java.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lixhui
 * @create 2021-09-19:20
 */
public class CompareTest {
    @Test
    public void test1(){
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("lianxiang",4200);
        goods[1] = new Goods("huawei",6000);
        goods[2] = new Goods("xiaomi",2000);
        goods[3] = new Goods("huipu",8000);
        goods[4] = new Goods("apple",12000);
        goods[5] = new Goods("dell",6000);

        Arrays.sort(goods);

        System.out.println(Arrays.toString(goods));


    }

    @Test
    public void test2(){
        Goods[] goods = new Goods[7];
        goods[0] = new Goods("lianxiang",4200);
        goods[1] = new Goods("huawei",6000);
        goods[2] = new Goods("xiaomi",2000);
        goods[3] = new Goods("huipu",8000);
        goods[4] = new Goods("apple",12000);
        goods[5] = new Goods("dell",6000);
        goods[6] = new Goods("huawei",7000);

        Arrays.sort(goods, new Comparator() {//自定义比较

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods){
                    Goods goods1 = (Goods) o1;
                    Goods goods2 = (Goods) o2;
                    if(goods1.getName().equals(goods2.getName())){
                        return -  Double.compare(goods1.getPrice(),goods2.getPrice());
                    }else {
                        return goods1.getName().compareTo(goods2.getName());
                    }
                }
                throw new RuntimeException("传入的数据不匹配");
            }
        });

        System.out.println(Arrays.toString(goods));
    }
}
