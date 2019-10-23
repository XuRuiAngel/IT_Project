package com.it.springbootdemo.service;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface IncomeService {

    public void addIncome(String time,int type,double money);

    public JSONObject getIncome();
}
