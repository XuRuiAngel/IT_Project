package com.it.springbootdemo.service;

import com.it.springbootdemo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {



    public User test2(int id);

    public int login(String username,String password);

    public int registLibrarian(String tele,String password,String e_mail);

}
