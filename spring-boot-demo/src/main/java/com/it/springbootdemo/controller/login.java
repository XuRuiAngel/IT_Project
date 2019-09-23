package com.it.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class login {

    @RequestMapping("/test2")
    public String test(){
        return "test";
    }
}
