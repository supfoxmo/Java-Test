package com.atguigu.java2;

import org.junit.Test;

import java.util.Optional;

/**
 * @author lixhui
 * @create 2021-10-14:19
 */
public class OptionalTest {
    //Optional.of(T t):创建一个Optional实例，t必须非空
    //Optional.empty():创建一个人空的Optional实例
    //Optional.ofNullable(T t):创建一个Optional实例，t可以非空


    //Optional类相当一个容器，可以包装任何类
    @Test
    public void test1(){
        Gril gril = new Gril();
        Optional<Gril> grilOptional = Optional.of(gril);

        System.out.println(grilOptional);//Optional[Gril{name='null'}]
    }
    @Test
    public void test2(){
        Gril gril = new Gril();
        gril = null;
        Optional<Gril> grilOptional = Optional.ofNullable(gril);

        System.out.println(grilOptional);//Optional.empty
    }

    public String getGrilName(Boy boy){
        return boy.getGril().getName();
    }
    @Test
    public void test3(){
        Boy boy = new Boy();
        String grilName = getGrilName(boy);//NullPointerException
        System.out.println(grilName);
    }
    //优化以后的getGrilName1()

    public String getGrilName1(Boy boy){
        if (boy != null){
            Gril gril = boy.getGril();
            if (gril != null){
                return gril.getName();
            }
        }
        return null;
    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        String grilName = getGrilName1(boy);
        System.out.println(grilName);//null

        Boy boy1 = new Boy(new Gril("迪丽热巴"));
        String grilName1 = getGrilName1(boy1);
        System.out.println(grilName1);//迪丽热巴
    }

    //使用Optional类优化后的getGrilName2()
    public String getGrilName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        //orElse(T t1):如果当前Optional内部封装的 t是非空的，则返回内部的 t。
        //如果内部的 t是空的，则返回orElse()方法中的参数
        Boy boy1 = boyOptional.orElse(new Boy(new Gril("迪丽热巴")));

        Optional<Gril> grilOptional = Optional.ofNullable(boy1.getGril());
        Gril gril = grilOptional.orElse(new Gril("佟丽娅"));

        return gril.getName();

    }

    @Test
    public void test5(){
        Boy boy = new Boy();
        String grilName = getGrilName2(boy);
        System.out.println(grilName);//佟丽娅

        Boy boy1 = null;
        String grilName2 = getGrilName2(boy1);
        System.out.println(grilName2);//迪丽热巴

        Boy boy2 = new Boy(new Gril("古力娜扎"));
        String grilName1 = getGrilName2(boy2);
        System.out.println(grilName1);//古力娜扎

    }
}
