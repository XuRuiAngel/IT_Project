package com.it.springbootdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.it.springbootdemo.service.BookService;
import com.it.springbootdemo.utils.EmailUtils;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework. stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

  /*  @GetMapping("/sendEmail")
    @ResponseBody
    public String sendEmail() throws JsonProcessingException {
        boolean isSend = EmailUtils.sendEmail("这是一封测试邮件", new String[]{"693502886@qq.com"}, null, "<h3><a href='http://www.baidu.com'>百度一下，你就知道</a></h3>", null);
        return "发送邮件:" + isSend;
    }*/


    @GetMapping("/insertBookWithoutISBN")
    @ResponseBody
    public int insertBookWithoutISBN(@RequestParam("ISBN") String ISBN,
                                     @RequestParam("price")String price,
                                     @RequestParam("location")String location,
                                     @RequestParam("bookname") String bookname,
                                     @RequestParam("author")String author,
                                     @RequestParam("press")String press,
                                     @RequestParam("description")String description,
                                     @RequestParam("publishYear")String publishYear,
                                     @RequestParam("textLanguage")String textLanguage,
                                     @RequestParam("copyNumbers")int copyNumbers
                                     ){
        return bookService.insertBookWithoutISBN(ISBN,price,location,bookname,author,press,description,publishYear,textLanguage,copyNumbers);

    }

    @GetMapping("/insertBookWithISBN")
    @ResponseBody
    public int insertBookWithISBN(   @RequestParam("ISBN") String ISBN,
                                     @RequestParam("price")String price,
                                     @RequestParam("location")String location,
                                     @RequestParam("bookname") String bookname,
                                     @RequestParam("author")String author,
                                     @RequestParam("press")String press
    ){
        return bookService.insertBookWithISBN(ISBN,price,location,bookname,author,press);

    }

    @PostMapping("/deleteBook")
    @ResponseBody
    public String deleteBook(@RequestParam("bookId" ) int bookId,
                             @RequestParam("userId")int userId,
                             @RequestParam("reason") String reason){
        bookService.deleteBook(bookId);
        bookService.addDeletionReacord(bookId,userId,reason);
        return "success!";
    }

    @GetMapping("/getBookOrder")
    @ResponseBody
    public int getBookOrder(@RequestParam("bookId") int bookId){
        return bookService.getBookOrder(bookId);

    }

    @GetMapping("/getLastBookId")
    @ResponseBody
    public int getLastBookId(){
        return bookService.getLastBookId();
    }

    @PostMapping("/changeBook")
    @ResponseBody
    public String changeBook(@RequestParam("bookId") int bookId,
                             @RequestParam("description") String description,
                             @RequestParam("location") String location){
        int result=bookService.changeBook(bookId,description, location);
        if(result==1)
        return "success!";
        else return "error!";
    }

    @GetMapping("/getDeletionRecord")
    @ResponseBody
    public JSONObject getDeletionRecord(){
        return bookService.getDeletionRecord();
    }



}
