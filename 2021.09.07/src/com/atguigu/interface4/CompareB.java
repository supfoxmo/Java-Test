package com.atguigu.interface4;

public interface CompareB {
	
		public abstract void method1();
		
		public default void method2() {
			System.out.println("我要去上海");
		}
		
}
