package com.foxmo.java;

public class Test {
    public static void main(String[] args) {
        Count myCount = new Count();
        int times = 0;

        for (int i = 0; i < 100; i++) {
            increament(myCount,times);
        }

        System.out.println("李晓辉 " + myCount.count);
        System.out.println("times is " + times);
    }

    public static void increament(Count c,int times){
        c.count++;
        times++;
    }

}
