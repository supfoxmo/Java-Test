package com.atguigu.testmodule;

import org.junit.Test;

public class TestModule {
	
	

	@Test
	public void test1() {// 包装类
		// 基本数据类型-->包装类
		int sum = 10;
		Integer in1 = new Integer(sum);
		System.out.println(in1.toString());
		// 包装类-->基本数据类型
		int num = in1.intValue();
		System.out.println(num);
		// 基本数据类型-->包装类
		Integer in2 = new Integer(num);
		System.out.println(in2.toString());

		// 自动装箱与自动拆箱
		int num1 = 20;
		Integer in3 = num1;
		System.out.println(in3);

		Integer in4 = new Integer(20);
		int num2 = in4;
		System.out.println(num2);

	}

	@Test
	public void test2() {
		String str1 = "32479854";
		System.out.println(str1);

		char art = 'w';
		System.out.println(art);
	}

	@Test
	// 数组可以看成一种特殊的类，其根父类也是java.lang.Object
	public void test3() {
		int[] arr = new int[] { 1, 2, 3, };
		print(arr);

		System.out.println(arr.getClass());// 当前类的类名
		System.out.println(arr.getClass().getSuperclass());// 当前类的父类的类名
	}

	public void print(Object obj) {
		System.out.println(obj);
	}

}

