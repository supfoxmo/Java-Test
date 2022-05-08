package com.atguigu.java.thread;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 *
 * @author lixhui
 * @create 2021-09-13:57
 */

class MThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i <= 100;i++){
            if(i % 3 == 0){
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
        }
    }
}

public class  ThreadTest1 {
    public static void main(String[] args) {
        MThread threa = new MThread();

        Thread T1 = new Thread(threa);
        Thread T2 = new Thread(threa);

        T1.setName("线程一");
        T2.setName("线程二");

        T1.start();
        T2.start();
    }
}


