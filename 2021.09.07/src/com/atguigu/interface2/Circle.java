package com.atguigu.interface2;

public class Circle {
	private double redius;

	public Circle() {
		super();
	}

	public Circle(double redius) throws Exception {
		super();
		if(redius > 0) {
			this.redius = redius;
		}else {
			throw new Exception("传入的数据不匹配");
		}
		
	}

	public double getRedius() {
		return redius;
	}

	public void setRedius(double redius) throws Exception {
		if(redius > 0) {
			this.redius = redius;
		}else {
			throw new Exception("传入的数据不匹配");
		}
	}
	
	

}
