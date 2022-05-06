package com.atguigu.interface4;

//  1.若实现类实现的两个接口中定义了同名的抽象方法，则实现类只需重写其中一个抽象方法
//	2.若实现类实现的两个接口中定义了同名的默认方法，则实现类需要重写其中一个默认方法，不然会发生接口冲突
//	3.若一个类继承的父类和实现的接口中定义了同名的方法（默认方法），在子类调用该方法时，实际执行的是父类的方法

public class Interface extends SubClass implements CompareA, CompareB {

	public void method3() {
		method2();
	}
	
	@Override
	public void method2() {
		super.method1();// 调用父类的方法
		CompareA.super.method2();// 调用接口的默认方法
	}

	@Override
	public void method1() {
		System.out.println("我要环游世界");
	}

}
