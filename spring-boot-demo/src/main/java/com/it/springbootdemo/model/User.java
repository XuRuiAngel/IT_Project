package com.it.springbootdemo.model;

import lombok.Getter;

import java.util.Date;

public class User {
    private int userId;
    @Getter
    private String password;
    private String username;
    private String e_mail;
    private String tele;
    @Getter
    private int flag;
    private Date registerdate;
    private double balance;

    public User(int userId, String username,double balance, String e_mail,String password, int flag,String tele,  Date registerdate) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.e_mail = e_mail;
        this.tele = tele;
        this.flag = flag;
        this.registerdate = registerdate;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + userId +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", tele='" + tele + '\'' +
                ", flag=" + flag +
                ", registerdate='" + registerdate + '\'' +
                ", balance=" + balance +
                '}';
    }
}
