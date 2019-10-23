package com.it.springbootdemo.service;


import org.springframework.stereotype.Service;

@Service
public interface IncomeService {

    public void addIncome(String time,int type,double money);
}
