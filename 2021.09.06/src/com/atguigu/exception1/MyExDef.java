package com.atguigu.exception1;
//自定义异常类
/*
 * 1、继承现有的异常结构
 * 2、定义序列号
 * 3、设置构造器
 */
public class MyExDef extends Exception{
	static final long serialVersionUID = -338755432324229948L;
	
	public MyExDef() {
		super();
	}
	
	public MyExDef(String mags) {
		super(mags);
	}
}
