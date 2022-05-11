package com.atguigu.java;

/**
 * @author lixhui
 * @create 2021-10-14:25
 *
 * 静态代理
 * 特点:代理类和被代理类在编译期间就已经确定了
 */

interface ClothFactory {
    public void ProductCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }


    @Override
    public void ProductCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.ProductCloth();

        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{


    @Override
    public void ProductCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}


public class StaticProxyTest {
    public static void main(String[] args) {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);

        proxyClothFactory.ProductCloth();

    }
}
