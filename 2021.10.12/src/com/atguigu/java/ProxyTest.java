package com.atguigu.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lixhui
 * @create 2021-10-15:04
 *
 * 动态代理
 */

interface Human{
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        String belief = "I belief i can fly";

        return belief;
    }

    @Override
    public void eat(String food) {

        System.out.println("我喜欢吃" + food);
    }
}

/*
 * 要实现动态代理类，需要解决的问题：
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法。
 *
 */

class ProxyFactory{

    //调用此方法，返回一个代理类对象。
    public static Object getProxyInstance(Object obj){//obj:被代理类对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法A时，就会自动调用如下的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj：即为被代理类的对象
        Object returninvoke = method.invoke(obj, args);
        //上述方法的返回值就作为当前类的invoke()的返回值。
        return returninvoke;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        SuperMan superMan = new SuperMan();
        //创建代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();

        System.out.println(belief);

        proxyInstance.eat("四川麻辣烫");

        System.out.println("********************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyInstance1.ProductCloth();
    }
}
