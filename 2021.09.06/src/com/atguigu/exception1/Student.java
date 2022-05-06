package com.atguigu.exception1;

public class Student {
	private int id;
	private String name;
	private int age;
	
	public Student() {
		super();
	}

	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public void setid(int id) throws Exception {
		if(id > 0) {
			this.id = id;
		}else {
			throw new Exception("您输入的数据非法！");
		}
	}
	
	public int getid() { 
		return id;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public String getname() {
		return name;
	}
	
	public void setage(int age) throws MyExDef {
		if(age < 0 && age > 130) {
			this.age = age;
		}else {
			throw new MyExDef("您输入的数据不符合要求！");
		}
		
	}
	
	public int getage() {
		return age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
