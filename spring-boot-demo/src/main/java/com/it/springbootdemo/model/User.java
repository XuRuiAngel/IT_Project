package com.it.springbootdemo.model;

public class User {
    private int UserId;
    private String password;
    private String e_mail;
    private String tele;
    private int flag;
    private String registerdate;
    public User(int UserId,String password,String e_mail,String tele,int flag,String registerdate)
    {
          this.UserId=UserId;
          this.password=password;
          this.e_mail=e_mail;
          this.flag=flag;
          this.registerdate=registerdate
    }

    public String toString()
    {
        return this.UserId+" "+this.password+" "+this.e_mail+" "+this.flag+" "+this.registerdate;
    }
}
