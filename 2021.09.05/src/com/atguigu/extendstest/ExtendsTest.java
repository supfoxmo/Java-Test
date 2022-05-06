package com.atguigu.extendstest;

public class ExtendsTest {
	public static void main(String[] args) {
		Man m = new Man(103, "张三丰", 1001);
		Person p = new Man(23, "李延续", 1002);

		System.out.println(m.getName());
		System.out.println(m.getAge());
		System.out.println(m.id);
		System.out.println("*************");
		System.out.println(p.getName());
		System.out.println(p.getAge());
//		多态时，不能调用父类私有的属性和方法、
//		System.out.println(p.id);
//		私有的方法不能被重写
//		p.eat;
		p.sleep();
	}
}
