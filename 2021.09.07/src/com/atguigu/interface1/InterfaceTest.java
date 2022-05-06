package com.atguigu.interface1;

public class InterfaceTest{
	public static void main(String[] args) {
		System.out.println(Flyable.MAX_SPEED);
		System.out.println(Flyable.MIN_SREED);
//		Flyable.MAX_SPEED = 10;  不能修改常量的数据
		
		Plane p = new Plane();
		int s = p.fly();
		p.stop();
		System.out.println("s = " + s);
	}
}


interface Flyable{
//	全局常量
	public static final int MAX_SPEED = 7900;//public static final可省略
	public static final int MIN_SREED = 1;
//	抽象方法
	public abstract int fly();
	public abstract void stop();
//	接口中不能定义构造器
//	public Flyable() {
//		
//	}
	
}

class Plane implements Flyable{

	@Override
	public int fly() {
		System.out.println("第一宇宙速度为:" + Flyable.MAX_SPEED);
		return Flyable.MIN_SREED;
	}

	@Override
	public void stop() {
		System.out.println("停止飞行\n");
		
	}
	
}