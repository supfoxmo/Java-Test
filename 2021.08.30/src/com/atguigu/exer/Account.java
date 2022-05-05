package com.atguigu.exer;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	
	public Account(int id, double balance, double annualInterestRate ) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		
	}
	
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void setAnnualInteresRate(double annualInteresRate) {
		this.annualInterestRate = annualInteresRate;
	}
//	取钱
	public void withdraw(double amount) {
		if(balance >= amount) {
			System.out.println("成功取出:" + amount);
			balance -= amount;
		}else {
			System.out.println("余额不足,取款失败");
		}
	}
//	存钱
	public void deposit(double amount) {
		if(amount > 0) {
			System.out.println("成功存入:" + amount);
			balance += amount;
		}else {
			System.out.println("操作错误");
		}
	}
	
	

}
