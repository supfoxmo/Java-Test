package com.atguigu.java.java;

/**
 * @author lixhui
 * @create 2021-09-19:22
 */
public class Goods implements Comparable{
    private String name;
    private int price;

    public Goods() {
    }

    public Goods(String name,int price) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}' ;
    }


    @Override
    public int compareTo(Object o) {//自然比较
        if (o instanceof Goods){
            Goods goods = (Goods) o;
            if (this.price > goods.price){
                return 1;
            }else if (this.price < goods.price){
                return -1;
            }else{
//                return 0;
                return this.name.compareTo(goods.name);
            }
        }
        throw new RuntimeException("传入的数据不匹配");
    }
}