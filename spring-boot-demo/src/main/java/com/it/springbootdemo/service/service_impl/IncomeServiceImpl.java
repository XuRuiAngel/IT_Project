package com.it.springbootdemo.service.service_impl;

import com.it.springbootdemo.mapper.IncomeMapper;
import com.it.springbootdemo.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeMapper incomeMapper;
    @Override
    public void addIncome(String time, int type, double money) {
        incomeMapper.addIncome(time,type,money);
    }
}
