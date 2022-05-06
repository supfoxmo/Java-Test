package com.atguigu.interface2;

public class ComparableCircleTest {
	public static void main(String[] args) {
		ComparableCircle circle1 = new ComparableCircle();
		ComparableCircle circle2 = new ComparableCircle();

		try {
			circle1.setRedius(2.2);
			circle2.setRedius(1.2);

			int comparaValue = circle1.compareTo(circle2);
			if (comparaValue > 0) {
				System.out.println("ciecle1对象大");
			} else if (comparaValue < 0) {
				System.out.println("ciecle2对象大");
			} else {
				System.out.println("ciecle1对象和circle2对象一样大");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
