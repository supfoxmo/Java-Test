package com.atguigu.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建多线程的方式三：实现Callable接口
 * 1.创建一个实现了Callable接口的类
 * 2.实现类去实现Callable中的抽象方法call(),将此线程需要执行的操作声明在call()中
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到FutureTask类的构造器中，创建FutureTask类的对象
 * 5.将FutureTask的对象作为参数传递的Thread类的构造器中，创建Thread类的对象，并调用start()
 * 6.get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
 * <p>
 * <p>
 * Runnable与Callable
 * 1、相比run()方法，call()可以有返回值
 * 2、call()可以抛异常
 * 3、call() 支持泛型的返回值
 * 4、需要借助FutureTask类，比如获取返回结果
 *
 * @author lixhui
 * @create 2021-09-16:49
 */

class MyThread4 implements Callable {
    @Override
    public Object call() throws Exception {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                count += i;
            }
        }
        return count;//自动类型转换：基本数据类型--->包装类
    }
}

public class ThreadTest2 {

    public static void main(String[] args) {
        MyThread4 mythread4 = new MyThread4();

        FutureTask task = new FutureTask(mythread4);

        Thread mthread = new Thread(task);

        mthread.start();

        Object obj = new Object();
        try {
            obj = task.get();
            System.out.println("100之内的偶数和为：" + obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
