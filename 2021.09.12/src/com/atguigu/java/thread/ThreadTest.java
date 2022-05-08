package com.atguigu.java.thread;
/*
*多线程的创建，方式一：继承于Thread类
* 1、创建一个继承于Thread类的子类
* 2、重写Thread类的run（）-->将线程执行的操作声明在run（）中
* 3、创建Thread类的子类的对象
* 4、通过此对象调用start（）-->1启动当前线程  2调用当前线程的run（）
*
 */


/**
 * @author lixhui
 * @create 2021-09-21:40
 */

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i =0;i<=100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread T1 = new MyThread();
        T1.start();

        MyThread t1 = new MyThread();
        t1.start();
    }

}
