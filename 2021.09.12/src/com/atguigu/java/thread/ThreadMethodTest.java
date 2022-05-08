package com.atguigu.java.thread;

/**
 * 1、start()：启动当前线程；调用当前run()
 * 2、run()：通常需要重写Thread类中的子方法，将创建的线程要执行的操作声明在此方法中
 * 3、currentThread():静态方法，返回执行当前代码的线程
 * 4、getname()：获取当前线程的名字
 * 5、setname()：设置当前线程的名字
 * 6、yield():释放当前CPU的执行权
 * 7、join():在线程A中调用线程B的join()，此时线程A就进入阻塞状态，
 *          直到线程B完全执行完以后，线程A才结束阻塞状态
 * 8、stop():已过时。当执行此方法时，强行结束当前线程
 * 9、sleep(long millitime):让当前线程“休眠”指定的millitime毫秒。
 *                          在指定的millitime毫秒时间内，当前线程是阻塞状态
 * 10、isAlive():判断当前线程是否存活
 *
 *
 * @author lixhui
 * @create 2021-09-8:25
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.setName("线程一");
        t1.start();

        MyThread1 t2 = new MyThread1();
        t2.setName("线程二");
        t2.start();

        for (int j = 0;j <= 100;j++){
            if (j % 2 != 0){
                System.out.println(Thread.currentThread().getName() + "-" + j);
            }
            if (j == 20){
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    System.out.println(e.getStackTrace());
                }
            }


        }

        if(t1.isAlive()){
            System.out.println("线程一存活着");
        }else{
            System.out.println("线程一已死亡");
        }
    }

}


class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "-" + i);

            }
//            if (i == 20) {
//                yield ();
//            }

            if (i == 40) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

