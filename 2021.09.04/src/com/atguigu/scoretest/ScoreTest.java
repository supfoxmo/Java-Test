package com.atguigu.scoretest;

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
	public static void main(String[] args) {
		// 输入成绩
		Scanner scan = new Scanner(System.in);

		// 创建Vector对象：Vector v = new Vector();相当于原来的数组
		Vector v = new Vector();
		int maxScore = 0;
		// 通过循环，给Vector中添加数据
		for (;;) {

			System.out.println("请输入学生成绩(以负数戴白哦输入结束)");
			int score = scan.nextInt();
			// 当输入负数时，结束循环
			if (score < 0) {
				break;
			}
			if (score > 100) {
				System.out.println("输入错误，请重新输入");
				continue;
			}
			// 给Vector中添加数据
			v.addElement(score);
			// 选取最高成绩
			if (maxScore < score) {
				maxScore = score;
			}
			// 遍历Vector，得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级

		}
		char level;
		for (int i = 0; i < v.size(); i++) {
			Object obj = v.elementAt(i);
			// 向下转型
			Integer inScore = (Integer) obj;
			// 包装类-->基本数据类
			int score = inScore.intValue();
			// 或
//				int score = (int)obj;

			if (maxScore - score <= 10) {
				level = 'A';
			} else if (maxScore - score <= 20) {
				level = 'B';
			} else if (maxScore - score <= 30) {
				level = 'C';
			} else {
				level = 'D';
			}
			System.out.println("student-" + i + ",score is " + score + ",level is " + level);
		}
	}

}
