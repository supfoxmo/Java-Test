package com.atguigu.employee;

public class HourlyEmployee extends Employee {
	private int wage;//每小时的工资
	private int hour;//一个月的工作小时
	
	public HourlyEmployee(String name, int number, MyDate birthday) {
		super(name, number, birthday);
	}
	
	public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
		super(name, number, birthday);
		this.wage = wage;
		this.hour = hour;
	}


	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public double earnings() {
		return wage * hour;
	}
	
	@Override
	public String toString() {
		return "HourlyEmployee[" + super.toString() + "]";
	}


}
