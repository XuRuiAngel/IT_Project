package com.it.springbootdemo.controller;


import com.it.springbootdemo.model.User;
import com.it.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test {
@Autowired
    UserService userService;

    @GetMapping("/getUser")
    @ResponseBody
    public String test(@RequestParam("id") int id){

           return userService.test(id);
    }

    @GetMapping("/getUserbyid")
    @ResponseBody
    public String test2(@RequestParam("id") int id){
        User user = userService.test2(id);
        return user.toString();
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
