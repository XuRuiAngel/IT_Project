package com.it.springbootdemo.service;

import com.it.springbootdemo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {



    public User test2(int id);

    public int login(String tele,String password);

    public int registLibrarian(String tele,String username,String e_mail);

    public int registReader(String tele,String username,String e_mail,double balance);

    public int resetPassword(String tele,String e_mail);

}
