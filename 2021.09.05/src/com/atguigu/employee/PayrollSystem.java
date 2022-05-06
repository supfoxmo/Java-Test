package com.atguigu.employee;

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {
	public static void main(String[] args) {
		//方式一
//		Scanner scan = new Scanner(System.in);
//		System.out.println("请输入当月的月份:");
//		int month = scan.nextInt();
		//方式二
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);//获取当前月份   //January-->0
		
		Employee[] emps = new Employee[2];

		emps[0] = new SalariedEmployee("马森", 1001, new MyDate(1992, 9, 5), 10000);
		emps[1] = new HourlyEmployee("张学友", 1002, new MyDate(2000, 5, 6), 60, 240);

		for (int i = 0; i < emps.length; i++) {
			System.out.println(emps[i].toString());
			double salary = emps[i].earnings();
			
			if(month + 1 == emps[i].getBirthday().getMonth()) {
				System.out.println("生日快乐！奖励100元");
				salary += 100;
			}
			
			System.out.println("月工资为:" + salary);
			
			System.out.println("**********************");
		}
	}

}
