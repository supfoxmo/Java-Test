package com.atguigu.java.thread;

/**
 * @author lixhui
 * @create 2021-09-20:38
 */
public class ThreadPriorityTeat {
    public static void main(String[] args) {
        MyThread2 th1 = new MyThread2();
        th1.setPriority(Thread.MAX_PRIORITY);
        th1.setName("线程一");
        th1.start();

        MyThread2 th2 = new MyThread2();
        th2.setPriority(Thread.MIN_PRIORITY);
        th2.setName("线程二");
        th2.start();


    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i <= 100;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "--"
                        + Thread.currentThread().getPriority() + "--" + i);
            }
        }
    }
}
