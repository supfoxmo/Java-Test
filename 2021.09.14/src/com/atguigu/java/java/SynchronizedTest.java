package com.atguigu.java.java;

/**
 * @author lixhui
 * @create 2021-09-19:45
 */

class MyThread implements Runnable{
    private int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {

        while (true){
//            同步代码块处理实现Runable接口的线程安全问题
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

public class SynchronizedTest {
    public static void main(String[] args) {
        MyThread M = new MyThread();

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
