package com.it.springbootdemo.service.service_impl;


import com.it.springbootdemo.mapper.BookMapper;
import com.it.springbootdemo.model.Book;
import com.it.springbootdemo.service.BookService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public int getBookOrder(int bookId) {
        return bookMapper.getBookOrder(bookId);
    }

    @Override
    public int deleteBook(int bookId) {
        bookMapper.deleteBook(bookId);
        return 0;
    }

    @Override
    public JSONObject searchBook(String key, String text) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<Book> books=bookMapper.searchBook(key,text);
        jsonObject.put("number",books.size());
        for(Book book:books)
        {
            JSONObject result=new JSONObject();
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
            jsonArray.add(result);
        }
        jsonObject.put("result",jsonArray);
        return jsonObject;

    }

    @Override
    public int insertBookWithoutISBN(String price, String location, String bookname, String author, String press) {
        bookMapper.insertBookWithoutISBN(price,location,bookname,author,press);
        return 1;
    }

    @Override
    public int insertBookWithISBN(String ISBN, String price, String location, String bookname, String author, String press) {
        bookMapper.insertBookWithISBN(ISBN,price,location,bookname,author,press);
        return 1;
    }


}
