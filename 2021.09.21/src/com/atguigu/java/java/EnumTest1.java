package com.atguigu.java.java;

/**
 * @author lixhui
 * @create 2021-09-12:38
 */
public class EnumTest1 {
    public static void main(String[] args) {
        System.out.println(Season1.SPRING);//默认输出当前枚举类对象常量名称
        System.out.println(Season1.SUMMER);//默认输出当前枚举类对象常量名称
        System.out.println(Season1.AUTUMN);//默认输出当前枚举类对象常量名称
        System.out.println(Season1.WINTER);//默认输出当前枚举类对象常量名称

        System.out.println(Season1.class.getSuperclass());
        System.out.println("*****************************");

        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        System.out.println("*****************************");
        Season1 spring = Season1.valueOf("SPRING");
        System.out.println(spring);
        System.out.println("*****************************");
        spring.show();
        Season1.SUMMER.show();
        Season1.AUTUMN.show();
        Season1.WINTER.show();

    }
}

interface info{
    void show();
}

enum Season1 implements info{//enum类的父类为:class java.lang.Enum
    SPRING("春天","春和日丽"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天的风");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋收的喜悦");
        }
    },
    WINTER("冬天","冰寒侧骨"){
        @Override
        public void show() {
            System.out.println("大约在冬天");
        }
    };

    //1、声明Season对象的属性：private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //2、私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4、其他诉求，获取枚举类的对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
