package com.project.java;

import java.util.ArrayList;

/**
 * @author lixhui
 * @create 2021-10-14:21
 */
public class Dish {
    static public ArrayList<Food> foods = new ArrayList<>();
    static public ArrayList<Food> order = new ArrayList<>();

    public Dish() {
        initMenu();
    }
    //主菜单界面

    public void showMainMenu(){
        System.out.println("============主菜单============");
        System.out.println("\t\t菜单\t\t1");
        System.out.println("\t\t以选菜品 \t2");
        System.out.println("\t\t买单\t\t3");
        System.out.println("==========选择功能项==========");
    }
    //初始化菜单

    private void initMenu(){
        foods.add(new Food(1,"鱼香肉丝",47.3));
        foods.add(new Food(2,"白切鸡",35.5));
        foods.add(new Food(3,"剁椒鱼头",59.7));
        foods.add(new Food(4,"宫保鸡丁",42.8));
        foods.add(new Food(5,"红烧茄子",23.0));
        foods.add(new Food(6,"麻婆豆腐", 28.3));
        foods.add(new Food(7,"炖王八",78.9));
        foods.add(new Food(8,"水煮白菜",12.0));
        foods.add(new Food(9,"大碗米饭",5.0));
    }

    //菜单界面
    public void showMenu(){

        System.out.println("=================菜单=================");

        System.out.println("序号\t\t\t" + "菜名\t\t\t" + "价格");

        for (int i = 0; i < foods.size(); i++) {
            System.out.println(" " + foods.get(i).getId() + "\t\t\t\t" + foods.get(i).getName() + "\t\t\t" + foods.get(i).getPrice());
        }

        System.out.println("=========序号点菜,按0返回主菜单=========");
    }

    //点餐
    public void orders(int i){
        for (int j = 0; j < foods.size(); j++) {
            if (foods.get(j).getId() == i){
                order.add(foods.get(j));
                System.out.println("你已成功点餐：" + foods.get(j).getName());
            }
        }
    }

    //展示以选菜品
    public void customerMenu(){
        System.out.println("===============以选菜单===============");

        System.out.println("序号\t\t\t" + "菜名\t\t\t" + "价格");

        for (int i = 0; i < order.size(); i++) {
            System.out.println(" " + order.get(i).getId() + "\t\t\t\t" + order.get(i).getName() + "\t\t\t" + order.get(i).getPrice());
        }

        System.out.println("============按0返回主菜单=============");
    }


    //买单
    public double check(){
        double totalPrice = 0;
        for (int i = 0; i < order.size(); i++) {
            totalPrice += order.get(i).getPrice();
        }
        return totalPrice;
    }


}
