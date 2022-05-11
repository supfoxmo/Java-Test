package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixhui
 * @create 2021-10-14:04
 */
public class EmployeeData {
    public static List<Employee> getEmployees(){
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(1001,"马化腾",34,6000.38));
        list.add(new Employee(1002,"马云",24,9870.58));
        list.add(new Employee(1003,"刘强东",33,4580.90));
        list.add(new Employee(1004,"雷军",26,7657.50));
        list.add(new Employee(1005,"李彦宏",65,7945.33));
        list.add(new Employee(1006,"比尔盖茨",45,9508.89));
        list.add(new Employee(1007,"任正非",67,4652.89));
        list.add(new Employee(1008,"扎克伯格",35,3576.72));

        return list;
    }
}
