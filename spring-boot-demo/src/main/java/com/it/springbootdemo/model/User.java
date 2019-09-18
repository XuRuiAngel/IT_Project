package com.it.springbootdemo.model;

public class User {
    private int id;
    private String name;
    private String passWord;
    private String eMail;
    private String account;
    public User(int id,String name,String passWord,String eMail,String account)
    {
          this.id=id;
          this.name=name;
          this.passWord=passWord;
          this.eMail=eMail;
          this.account=account;
    }

    public String toString()
    {
        return this.id+" "+this.name+" "+this.passWord+" "+this.eMail+" "+this.account;
    }
}
