package com.atguigu.equalstest;

public class Man extends Person{
	
	public Man(String name, int age) {
		super(name,age);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Man) {
			Man m = (Man)obj;
			return this.age == m.age && this.name.equals(m.name);
		}
		return false;
	}
}
