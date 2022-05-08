package com.atguigu.java.thread;

/**
 * @author lixhui
 * @create 2021-09-21:13
 */

class MyThread3 implements Runnable{
    private int count = 100;
    @Override
    public void run() {
        while (true){
            if (count > 0){
                System.out.println(Thread.currentThread().getName() + " 成功火车票的号码为" + count);
                count--;
            }
        }
    }
}

public class TickeWindowTest {
    public static void main(String[] args) {
        MyThread3 th = new MyThread3();

        Thread thr1 = new Thread(th);
        Thread thr2 = new Thread(th);

        thr1.setName("线程一");
        thr2.setName("线程二");

        thr1.start();
        thr2.start();

    }
}
