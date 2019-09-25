package com.it.springbootdemo.service;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    public JSONObject searchBook(String key,String text);
}
