package com.atguigu.java2;

/**
 * @author lixhui
 * @create 2021-10-14:20
 */
public class Gril {

    private String name;

    public Gril() {
    }

    public Gril(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Gril{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
