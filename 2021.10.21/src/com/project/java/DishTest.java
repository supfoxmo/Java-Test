package com.project.java;

import java.util.Scanner;

/**
 * @author lixhui
 * @create 2021-10-14:29
 */
public class DishTest {
    public static void main(String[] args) {
        Dish dish = new Dish();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            dish.showMainMenu();

            System.out.println("请输入你所选的选项编号");

            int num = scanner.nextInt();

            switch (num) {
                case 1:
                    dish.showMenu();
                    System.out.println("请选择你想要的菜品");
                    while (true) {
                        int i = scanner.nextInt();
                        if (i > 0 && i <= Dish.foods.size()) {
                            dish.orders(i);
                        } else if (i == 0) {
                            break;
                        } else {
                            System.out.println("输入的序号没有在菜单上，请重新输入！");
                        }
                    }
                    break;
                case 2:
                    //展示以选菜品
                    dish.customerMenu();
                    while (true){
                        int i = scanner.nextInt();
                        if (i == 0){
                            break;
                        }else{
                            System.out.println("输入错误，请重新输入！");
                        }
                    }
                    break;
                case 3:
                    //买单
                    double check = dish.check();
                    System.out.println("你已成功买单，总共消费：" + check + "，欢迎下次光临！");
                    return;
            }
        }
    }
}
