package com.atguigu.contact;

import java.util.Scanner;

public class HelloWorld {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		HelloWorld test = new HelloWorld();
		number1 num = new number1();
		num.a = 10;
		num.b = 20;
		test.exchange(num);
		System.out.println(num.a + " " + num.b);
	}

	public void exchange(number1 data) {
		int temp = data.a;
		data.a = data.b;
		data.b = temp;
	}

}

class number1 {
	int a;
	int b;
}
