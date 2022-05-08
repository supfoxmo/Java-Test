package com.atguigu.extendstest;

public class Person {
	 private int age;
	 private String name;
	 
	 public Person() {
	  super();
	 }
	 
	 public Person(int age, String name) {
	  super();
	  this.age = age;
	  this.name = name;
	 }

	 public int getAge() {
	  return age;
	 }

	 public void setAge(int age) {
	  this.age = age;
	 }

	 public String getName() {
	  return name;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 private void eat() {
	  System.out.println("吃饭");
	 }
	 
	 public void sleep() {
	  System.out.println("睡觉");
	 }
}
