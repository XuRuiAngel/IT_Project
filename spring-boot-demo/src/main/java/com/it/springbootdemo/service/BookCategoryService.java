package com.it.springbootdemo.service;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface BookCategoryService {
    public JSONObject getBookCatagory();

    public int addBookCatagory(String Typename);

    public int deleteBookCatagory(int ID);
}
