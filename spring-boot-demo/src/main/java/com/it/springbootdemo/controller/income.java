package com.it.springbootdemo.controller;


import com.it.springbootdemo.service.IncomeService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class income {
    @Autowired
    IncomeService incomeService;

    @PostMapping("/addIncome")
    @ResponseBody
    public void addIncome(@RequestParam("time")String time,
                          @RequestParam("type")int type,
                          @RequestParam("money") double money){
        incomeService.addIncome(time,type,money);
    }

    @GetMapping("/getIncome")
    @ResponseBody
    public JSONObject getIncome(){
        return incomeService.getIncome();
    }

}
