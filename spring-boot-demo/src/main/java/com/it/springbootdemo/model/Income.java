package com.it.springbootdemo.model;

public class Income {
    private String time;
    private int type;
    private double money;
    public Income(String time,int type,double money){
        this.time=time;
        this.type=type;
        this.money=money;
    }

    String getTime(){return this.time;}
    int getType(){return this.type;}
    double getMoney(){return this.money;}
}
