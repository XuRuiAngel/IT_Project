package com.it.springbootdemo.service;


import org.springframework.stereotype.Service;

@Service
public interface SetService {

    public double getFine();
    public double getPeriod();
    public double getDeposit();
    public int setFine(double fine);
    public int setPeriod(double period);
    public int setDeposit(double deposit);
}


