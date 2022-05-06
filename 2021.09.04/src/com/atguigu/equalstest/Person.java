package com.atguigu.equalstest;

public class Person {
	public String name;
	public int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Person) {
			Person p = (Person)obj;
			return this.age == p.age && this.name.equals(p.name);
		}
		return false;
	}
	

}
