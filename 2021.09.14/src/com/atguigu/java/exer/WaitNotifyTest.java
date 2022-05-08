package com.atguigu.java.exer;

/**
 * 1、执行wait()方法时，会使当前线程进入阻塞状态，并释放锁
 * 2、执行notify()方法时，会唤醒被wait()的线程，如果被wait()的线程有多个，则唤醒优先级较高的
 * 3、执行notifyAll()方法时，会唤醒所有被wait()的线程
 * <p>
 * 注意：
 * 1、wait()、notify()、notifyAll()只能在同步代码块或同步方法中调用
 * 2、wait()、notify()、notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器，否则会出现异常
 * 3、wait()、notify()、notifyAll()三个方法是 定义在Java.lang.Object类中
 *
 * @author lixhui
 * @create 2021-09-22:28
 */

class Clerk {
    private int product = 0;


    public synchronized void productorproduct() {
        if (product < 20) {
            product++;
            System.out.println(Thread.currentThread().getName() + ":生产第" + product + "产品");
            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void customerproduct() {
        if (product > 0) {
            System.out.println(Thread.currentThread().getName() + ":消费第" + product + "产品");
            product--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Productor extends Thread {
    private Clerk clerk;

    public Productor(Clerk clerk1) {
        this.clerk = clerk1;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + ":开始生产产品.......");
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productorproduct();
        }


    }
}

class Customer extends Thread {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + ":开始消费产品.........");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.customerproduct();
        }

    }

}


public class WaitNotifyTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor productor = new Productor(clerk);
        Customer customer = new Customer(clerk);

        productor.setName("生产者1");
        customer.setName("消费者1");

        productor.start();
        customer.start();

    }
}
