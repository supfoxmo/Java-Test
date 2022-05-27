package com.project.java;

/**
 * @author lixhui
 * @create 2021-10-8:35
 */
public class Bill {
    private String name;
    private double total;
    private String type;
    private String account;
    private String time;
    private String desc;

    public Bill() {
    }

    public Bill(String name, double total, String type, String account, String time, String desc) {
        this.name = name;
        this.total = total;
        this.type = type;
        this.account = account;
        this.time = time;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
