package com.it.springbootdemo.model;

public class User {
    private int UserId;
    private String password;
    private String e_mail;
    private String tele;
    private int flag;
    private String registerdate;
    private double balance;

    public User(int userId, String password, String e_mail, String tele, int flag, String registerdate, double balance) {
        this.UserId = userId;
        this.password = password;
        this.e_mail = e_mail;
        this.tele = tele;
        this.flag = flag;
        this.registerdate = registerdate;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", password='" + password + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", tele='" + tele + '\'' +
                ", flag=" + flag +
                ", registerdate='" + registerdate + '\'' +
                ", balance=" + balance +
                '}';
    }
}
