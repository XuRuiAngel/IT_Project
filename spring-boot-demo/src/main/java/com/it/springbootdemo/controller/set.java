package com.it.springbootdemo.controller;


import com.it.springbootdemo.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class set {


    @Autowired
    SetService setService;

    @GetMapping("/getFine")
    @ResponseBody
    public double getFine(){
        return setService.getFine();
    }

    @GetMapping("/getPeriod")
    @ResponseBody
    public double getPeriod(){
        return setService.getPeriod();
    }

    @GetMapping("/getDeposit")
    @ResponseBody
    public double getDeposit(){
        return setService.getDeposit();
    }

    @PostMapping("/setFine")
    @ResponseBody
    public String setFine(@RequestParam("fine") double fine){
        int result=setService.setFine(fine);
        if(result==1) return "success!";
        else return "error!";
    }

    @PostMapping("/setPeriod")
    @ResponseBody
    public String setPeriod(@RequestParam("period") double period){
        int result =setService.setPeriod(period);
        if (result==1) return "success!";
        else return "error!";
    }

    @PostMapping("/setDeposit")
    @ResponseBody
    public String setDeposit(@RequestParam("deposit") double deposit){
        int result =setService.setDeposit(deposit);
        if (result==1) return "success!";
        else return "error!";
    }
}
