package com.atguigu.java.java;

/**
 * @author lixhui
 * @create 2021-09-20:42
 */
class MyThread3 extends Thread {
    private static int ticket = 100;
    static Object obj = new Object();

    @Override
    public void run() {

        while (true) {
//            同步方法处理继承Thread类的线程安全问题
            Show1();

        }
    }

    public static synchronized void Show1() {//同步监视器为：MyThread3.class/当前类本身
//        public synchronized void Show1(){//同步监视器为：t1,t2,t3. 错误
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "购票，票号为：" + ticket);
            ticket--;
        }
    }

}

public class SynchronizedTest3 {
    public static void main(String[] args) {

        MyThread3 t1 = new MyThread3();
        MyThread3 t2 = new MyThread3();
        MyThread3 t3 = new MyThread3();

        t1.setName("线程一");
        t2.setName("线程二");
        t3.setName("线程三");

        t1.start();
        t2.start();
        t3.start();

    }

}

