package com.project.java;

import java.util.ArrayList;

/**
 * @author lixhui
 * @create 2021-10-8:36
 */
public class View {
    public void mainMenu() {
        System.out.println("==========================记账本=========================");
        System.out.println("                         添加账务                        ");
        System.out.println("                         删除账务                        ");
        System.out.println("                         查询账务                        ");
        System.out.println("                         退出系统                        ");
        System.out.println("====================请输入功能序号【1-4】：===============");
    }

    //初始化账单
    public void initialBill(){
        ArrayList<Bill> bills = new ArrayList<>();

        bills.add(new Bill("约客吃饭",250,"支出","微信支付","2020-2-28","人情事故，友好往来"));
        bills.add(new Bill("旅游出行",3000,"支出","银行账户","2020-4-13","放松心情，减轻压力"));
        bills.add(new Bill("更换设备",2800,"支出","银行账户","2021-1-30","提高工作效率"));
        bills.add(new Bill("工资发放",8000,"收入","银行账户","2021-5-30","钱包有钱，心里不慌"));
        bills.add(new Bill("日常吃饭",2500,"支出","微信支付","2021-6-10","补充营养，健康成长"));
    }
}
