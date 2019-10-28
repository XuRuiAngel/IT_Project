package com.it.springbootdemo.service;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface BookLocationService {
    public JSONObject getBookLocation();

    public int addBookLocation(int FloorNo,int ShelfNo);

    public  int deleteBookLocation(int ID);
}
