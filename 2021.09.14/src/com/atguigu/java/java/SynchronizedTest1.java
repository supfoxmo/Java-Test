package com.atguigu.java.java;

/**
 * @author lixhui
 * @create 2021-09-20:10
 */


class MyThread1 extends Thread{
    private static int ticket = 100;
    static Object obj = new Object();

    @Override
    public void run() {

        while (true){
//            同步代码块处理继承Thread类的线程安全问题
            synchronized (obj){

                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "购票，票号为：" + ticket );
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}

public class SynchronizedTest1 {
    public static void main(String[] args) {

        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        MyThread1 t3 = new MyThread1();

        t1.setName("线程一");
        t2.setName("线程二");
        t3.setName("线程三");

        t1.start();
        t2.start();
        t3.start();

    }

}