package com.atguigu.exception1;

public class ExceptionTest {
	public static void main(String args[]) {
		Student s = new Student(1000,"陈大牛",24);
		try {
			s.setage(-1);
			System.out.println(s);//不运行
		}catch(MyExDef e){
			System.out.println(e.getMessage());
		}
		System.out.println(s);//运行
	}

}
