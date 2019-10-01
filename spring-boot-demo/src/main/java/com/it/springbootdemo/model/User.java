package com.it.springbootdemo.model;



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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
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
