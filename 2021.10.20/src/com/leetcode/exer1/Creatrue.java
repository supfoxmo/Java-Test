package com.leetcode.exer1;

/**
 * @author lixhui
 * @create 2021-10-13:45
 */
public class Creatrue {
    private String name;

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Creatrue() {
    }

    public Creatrue(String name) {
        this.name = name;
    }

    public void sleep(){
        System.out.println("睡觉是恢复体能的最好方式");
    }

    public void eat(){
        System.out.println("生物需要通过进食，才能维持身体的机能");
    }
}
