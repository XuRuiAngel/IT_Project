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
    public String login(@RequestParam("tele") String tele,
                        @RequestParam("password") String password){
        int result;
        result=userService.login(tele,password);
        if(result==4){
            return "Account does not exist!";
        }
        else if(result==5){
            return "Password error!";
        }
        else return result+"";
    }

    @PostMapping("/registAdmin")
    @ResponseBody
    public String registAdmin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("e_mail") String e_mail){
        int result;
        result=userService.registAdmin(username,password,e_mail);
         if(result==0)
         {
             return "Please change username!";
         }
         else return "success!";
    }


}
