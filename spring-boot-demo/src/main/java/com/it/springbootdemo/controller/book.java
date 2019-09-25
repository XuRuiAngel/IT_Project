package com.it.springbootdemo.controller;

import com.it.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import net.sf.json.JSONObject;

@Controller
public class book {

    @Autowired
    BookService bookService;

    @GetMapping("/searchBook")
    @ResponseBody
    public JSONObject searchBook(@RequestParam("key")String key,
                                @RequestParam("text")String text){

        return bookService.searchBook(key,text);
    }
}
