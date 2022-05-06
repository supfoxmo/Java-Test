package com.atguigu.interface4;

public interface CompareA {
	public abstract void method1();
	
	public default void method2() {
		System.out.println("我要去北京");
	}
	

}
