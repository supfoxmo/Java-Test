package com.atguigu.equalstest;
//自定义equals与自动生成equals的区别(自定义equals存在缺陷)
public class PersonTest {
	public static void main(String[] args) {
		
		Person p = new Person("Tom",12);
	    Man m = new Man("Tom",12);
	    
	    System.out.println(p.equals(m));//true
	    System.out.println(m.equals(p));//false
	}
	
}
