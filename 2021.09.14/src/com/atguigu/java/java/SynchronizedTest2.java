package com.atguigu.java.java;

/**
 * @author lixhui
 * @create 2021-09-20:21
 */
class MyThread2 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {

        while (true){
//            同步方法处理实现Runable接口的线程安全问题

                show();

        }

    }


    public synchronized void show(){//同步监视器为this
        if (ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "购票，票号为：" + ticket );
            ticket--;
        }
    }

}

public class SynchronizedTest2{
    public static void main(String[] args) {
        MyThread1 M = new MyThread1();

        Thread t1 = new Thread(M);
        Thread t2 = new Thread(M);
        Thread t3 = new Thread(M);

        t1.setName("线程一");
        t2.setName("线程二");
        t3.setName("线程三");

        t1.start();
        t2.start();
        t3.start();

    }

}