package com.atguigu.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：使用线程池
 * 1、提供指定线程数量的线程池
 * 2、继承Runnable或实现Callable，重写Run()或Call()方法
 * 3、调用excute()或submit()方法，执行指定线程操作
 * 4、关闭线程池shutdown()
 *
 *
 * 使用线程池的优点：
 * 1、提高相应速度（减少了新创建线程的时间）
 * 2、降低资源消耗（重复利用线程池中的线程，不需要每次都才能给剑魂
 * 3、便于线程管理
 *
 * @author lixhui
 * @create 2021-09-9:40
 *
 */

class MyThread5 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class MyThread6 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}


class MyThread7 implements Callable {
    @Override
    public Object call() throws Exception {
        int count = 0;
        for (int i = 100; i < 200; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
                count += i;
            }
        }
        return count;
    }
}



public class ThreadTeat3 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
//      由于ExecutorService是接口，需转化为ThreadPoolExecutor才能对线程进行管理
        ThreadPoolExecutor servicre1 = (ThreadPoolExecutor) service;
        servicre1.setCorePoolSize(10);

        MyThread5 numthread1 = new MyThread5();
        MyThread6 numthread2 = new MyThread6();
        MyThread7 numthread3 = new MyThread7();

        service.execute(numthread1);//适合用于Runnable
        service.execute(numthread2);//适合用于Runnable
        service.submit(numthread3);//适用于Callable

        service.shutdown();//关闭线程池
    }
}