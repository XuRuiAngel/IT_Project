package com.it.springbootdemo.service;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    public JSONObject searchBook(String key,String text);

    public  int insertBookWithoutISBN(String price, String location, String bookname, String author, String press);

    public  int insertBookWithISBN(String ISBN,String price, String location, String bookname, String author, String press);
}
