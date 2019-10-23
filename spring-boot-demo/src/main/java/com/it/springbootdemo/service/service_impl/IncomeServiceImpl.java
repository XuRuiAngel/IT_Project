package com.it.springbootdemo.service.service_impl;

import com.it.springbootdemo.mapper.IncomeMapper;
import com.it.springbootdemo.model.Income;
import com.it.springbootdemo.service.IncomeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeMapper incomeMapper;
    @Override
    public void addIncome(String time, int type, double money) {
        incomeMapper.addIncome(time,type,money);
    }

    @Override
    public JSONObject getIncome() {
        List<Income> incomes=null;
        incomes=incomeMapper.getIncome();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        for(Income income:incomes)
        {
            JSONObject result=new JSONObject();
            result.put("time",income.getTime());
            result.put("type",income.getType());
            result.put("money",income.getMoney());
            jsonArray.add(result);
        }
        jsonObject.put("result",jsonArray);

        return jsonObject;
    }
}
