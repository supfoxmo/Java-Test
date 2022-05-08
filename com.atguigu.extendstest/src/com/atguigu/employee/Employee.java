package com.atguigu.employee;

public abstract class Employee {
	private String name;
	private int number;
	private MyDate birthday;
	
	public abstract void earnings();

	@Override
	public String toString() {
		return "Employee [name=" + name + ", number=" + number + ", birthday=" + birthday + "]";
	}
	

}
