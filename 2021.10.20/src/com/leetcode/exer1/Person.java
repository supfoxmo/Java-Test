package com.leetcode.exer1;

/**
 * @author lixhui
 * @create 2021-10-13:46
 */
public class Person extends Creatrue{
    private int id;
    private int phone;

    public Person() {

    }

    public Person(int id, int phone) {
        this.id = id;
        this.phone = phone;
    }

    public Person(String name, int id, int phone) {
        super(name);
        this.id = id;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", phone=" + phone +
                '}';
    }

    public void sleep(){
        System.out.println("人类都喜欢睡懒觉");
    }

    public void work(){
        System.out.println("人类要工作上班");
    }
}
