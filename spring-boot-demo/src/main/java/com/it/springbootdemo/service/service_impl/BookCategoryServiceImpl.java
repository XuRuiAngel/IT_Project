package com.it.springbootdemo.service.service_impl;


import com.it.springbootdemo.mapper.BookCategoryMapper;
import com.it.springbootdemo.model.BookCatagory;
import com.it.springbootdemo.service.BookCategoryService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    BookCategoryMapper bookCategoryMapper;
    @Override
    public JSONObject getBookCatagory() {
        List<BookCatagory> bookCatagories=null;
        bookCatagories=bookCategoryMapper.getBookCatagory();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        for(BookCatagory bookCatagory:bookCatagories)
        {
            JSONObject result=new JSONObject();
            result.put("categoryID",bookCatagory.getCategoryID());
            result.put("Typename",bookCatagory.getTypeName());

            jsonArray.add(result);
        }
        jsonObject.put("result",jsonArray);
        return jsonObject;
    }

    @Override
    public int addBookCatagory(String Typename) {

        BookCatagory test= bookCategoryMapper.findBookCatagoryByName(Typename);
        if(test!=null)
        {
            return 0;
        }
        else {
            bookCategoryMapper.addBookCatagory(Typename);
            return 1;
        }

    }

    @Override
    public int deleteBookCatagory(int ID) {
        bookCategoryMapper.deleteBookCatagory(ID);
        return 0;
    }
}
