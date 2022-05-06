package com.atguigu.extendstest;

public class Man extends Person {
	public int id;

	public Man(int id) {
		super();
		this.id = id;
	}

	public Man(int age, String name, int id) {
		super(age, name);
		this.id = id;
	}

	public void eat() {
		System.out.println("男人要多吃饭");
	}

	public void sleep() {
		System.out.println("男人要少睡觉");
	}
}
