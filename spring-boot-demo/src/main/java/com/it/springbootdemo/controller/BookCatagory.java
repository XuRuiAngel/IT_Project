package com.it.springbootdemo.controller;


import com.it.springbootdemo.service.BookCategoryService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookCatagory {
    @Autowired
    BookCategoryService bookCategoryService;
    @GetMapping("/getBookCatagory")
    @ResponseBody
    public JSONObject getBookCatagory(){
        return bookCategoryService.getBookCatagory();
    }

    @PostMapping("/addBookCatagory")
    @ResponseBody
    public String addBookCatagory(@RequestParam("Typename") String Typename){
       int result= bookCategoryService.addBookCatagory(Typename);
       if(result==0){
           return "The category already exists!";
       }
       else return  "Success!";
    }

    @PostMapping("/deleteBookCatagory")
    @ResponseBody
    public String deleteBookCatagory(@RequestParam("ID") int ID){
       bookCategoryService.deleteBookCatagory(ID);
        return  "Success!";
    }

}
