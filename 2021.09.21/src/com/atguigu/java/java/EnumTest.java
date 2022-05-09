package com.atguigu.java.java;

/**
 * @author lixhui
 * @create 2021-09-10:31
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);

        System.out.println(Season.class.getSuperclass());
    }
}

//自定义枚举类
class Season{//父类为：class java.lang.Object
    //1、声明Season对象的属性：private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //2、私有化类的构造器，并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3、提供当前枚举类的多个对象：public static final 的
    public static final Season SPRING = new Season("春天","春和日丽");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰寒侧骨");

    //4、其他诉求，获取枚举类的对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
