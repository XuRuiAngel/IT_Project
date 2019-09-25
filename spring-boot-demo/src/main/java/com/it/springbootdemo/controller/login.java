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

    @PostMapping("/registLibrarian")
    @ResponseBody
    public String registAdmin(@RequestParam("tele") String tele,
                               @RequestParam("username") String username,
                               @RequestParam("e_mail") String e_mail){
        int result;
        result=userService.registLibrarian(tele,username,e_mail);
         if(result==0)
         {
             return "The account has been registered!";
         }
         else return "success!";
    }

    @PostMapping("/registReader")
    @ResponseBody
    public String registReader(
            @RequestParam("tele") String tele,
            @RequestParam("username") String username,
            @RequestParam("e_mail") String e_mail,
            @RequestParam("balance") double balance){
                if(balance <300)
                {
                    return "not enough money";
                }
                else
                {
                    int result;
                    result=userService.registReader(tele,username,e_mail,balance);
                    if(result==0)
                    {
                        return "The account has been registered!";
                    }
                    else return "success!";
                }
                }
    }
