package com.it.springbootdemo.controller;

import com.it.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class login {

    @Autowired
    UserService userService;
    @GetMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        int result;
        result=userService.login(username,password);
        if(result==4){
            return "Username is not exist!";
        }
        else if(result==5){
            return "Password error!";
        }
        else return result+"";
    }


}
