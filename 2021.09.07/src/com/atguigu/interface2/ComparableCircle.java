package com.atguigu.interface2;

public class ComparableCircle extends Circle implements Comparable{

	@Override
	public int compareTo(Object o) {
		if(this == o) {
			return 0;
		}
		if(o instanceof ComparableCircle) {
			ComparableCircle circle = (ComparableCircle)o;
			if(this.getRedius() - circle.getRedius() > 0) {
				return 1;
			}else if(this.getRedius() - circle.getRedius() < 0) {
				return -1;
			}else {
				return 0;
			}
		}else {
			throw new RuntimeException("输入数据异常");
		}
		
	}
	
}
