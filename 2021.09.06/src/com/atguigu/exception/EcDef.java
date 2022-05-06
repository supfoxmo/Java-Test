package com.atguigu.exception;
//自定义异常类
public class EcDef extends Exception{
	static final long serialVersionUID = -33875169931948L;
	
	public EcDef() {
	}
	
	public EcDef(String msg) {
		super(msg);
	}
}
