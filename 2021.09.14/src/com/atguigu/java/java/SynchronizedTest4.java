package com.atguigu.java.java;

/**
 * 单例模型中线程安全的懒汉模型
 *
 * @author lixhui
 * @create 2021-09-21:24
 */
public class SynchronizedTest4 {

}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;
//    方式一：效率较差
//    public static Bank getinstance(){
//        synchronized (Bank.class){
//
//            if (instance == null){
//                instance = new Bank)();
//            }
//            return insance;
//        }
//    }

    //    方式二：效率较高
//    public static Bank getinstance() {
//        if (instance == null){
//
//            synchronized (Bank.class) {
//
//                if (instance == null) {
//                    instance = new Bank();
//                }
//                return instance;
//            }
//        }
//    }


}

