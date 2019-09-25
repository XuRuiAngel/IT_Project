package com.it.springbootdemo.service.service_impl;


import com.it.springbootdemo.mapper.BookMapper;
import com.it.springbootdemo.model.Book;
import com.it.springbootdemo.service.BookService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;
    @Override
    public JSONObject searchBook(String key, String text) {
        JSONObject jsonObject = new JSONObject();
        JSONObject result=new JSONObject();
        List<Book> books=bookMapper.searchBook(key,text);
        jsonObject.put("number",books.size());
        for(Book book:books)
        {
            result.put("bookId",book.getBookId());
            result.put("ISBN",book.getISBN());
            result.put("price",book.getPrice());
            result.put("location",book.getLocation());
            result.put("bookname",book.getBookName());
            result.put("author",book.getAuthor());
            result.put("press",book.getPress());
            result.put("description",book.getDescription());
            result.put("publishYear",book.getPublishYear());
            result.put("textLanguage",book.getTextLanguage());
            result.put("copyNumbers",book.getCopyNumbers());
        }
        jsonObject.put("result",result);
        return jsonObject;

    }
}
