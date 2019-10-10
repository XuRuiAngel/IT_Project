package com.it.springbootdemo.service.service_impl;

import com.it.springbootdemo.mapper.SetMapper;
import com.it.springbootdemo.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetServiceImpl implements SetService {

    @Autowired
    SetMapper setMapper;
    @Override
    public double getFine() {
        return setMapper.getFine();

    }

    @Override
    public double getPeriod() {
        return setMapper.getPeriod();
    }

    @Override
    public double getDeposit() {
        return setMapper.getDeposit();
    }

    @Override
    public int setFine(double fine) {
        setMapper.setFine(fine);
        return  1;
    }

    @Override
    public int setPeriod(double period) {
        setMapper.setPeriod(period);
        return 1;
    }

    @Override
    public int setDeposit(double deposit) {
        setMapper.setDeposit(deposit);
        return 1;
    }

}
