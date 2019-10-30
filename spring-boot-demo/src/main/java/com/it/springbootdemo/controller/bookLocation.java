package com.it.springbootdemo.controller;


import com.it.springbootdemo.service.BookLocationService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class bookLocation {
    @Autowired
    BookLocationService bookLocationService;

    @GetMapping("/getBookLocation")
    @ResponseBody
    public JSONObject getBookLocation(){
        return bookLocationService.getBookLocation();
    }
    @PostMapping("/addBookLocation")
    @ResponseBody
    public String addBookLocation(@RequestParam("FloorNo")int FloorNo,
                                  @RequestParam("ShelfNo") int ShelfNo){
        int result= bookLocationService.addBookLocation(FloorNo,ShelfNo);
        if(result==0){
            return "The Location already exists!";
        }
        else return  "Success!";
    }
    @PostMapping("/deleteBookLocation")
    @ResponseBody
    public String deleteBookLocation(@RequestParam("ID") int ID){
        bookLocationService.deleteBookLocation(ID);
        return  "Success!";
    }
}
