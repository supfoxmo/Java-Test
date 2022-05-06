package com.atguigu.java8.interface3;

public interface Methods {
	//定义静态常量
	public static int NUMBER = 100;
	public static double NUMBER1 = 200.0;
	//定义抽象方法
	public abstract void method1();
	public abstract void method2();
	//定义静态方法
	public static int method3() {
		System.out.println("接口中静态方法的使用");
		return 10;
	}
	//定义默认方法
	public default void method4() {
		System.out.println("接口中默认方法的使用");
	}
	
	
	

}
