package com.it.springbootdemo.model;

import lombok.Getter;

import java.util.Date;

public class User {
    private int userId;

    private String password;
    private String username;
    private String e_mail;
    private String tele;

    private int flag;
    private String registerdate;
    private double balance;

    public User(int userId, String username,double balance, String e_mail,String password, int flag,String tele,  String registerdate) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.e_mail = e_mail;
        this.tele = tele;
        this.flag = flag;
        this.registerdate = registerdate;
        this.balance = balance;
    }
    public User(String username,double balance,String e_mail,String password, int flag,String tele,  String registerdate) {

        this.password = password;
        this.username = username;
        this.e_mail = e_mail;
        this.tele = tele;
        this.flag = flag;
        this.registerdate = registerdate;
        this.balance = balance;

    }


    public int getFlag(){
        return this.flag;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUsername(){
        return this.username;
    }
    public String getE_mail(){
        return this.e_mail;
    }
    public String getTele(){
        return this.tele;
    }
    public int getUserId(){
        return this.userId;
    }
    public String getRegisterdate() {
        return this.registerdate;
    }

    public double getBalance() {
        return this.balance;
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
