package com.it.springbootdemo.controller;


import com.it.springbootdemo.service.RecordService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class record {
    @Autowired
    RecordService recordService;
    @PostMapping("/borrowBook")
    @ResponseBody
    public String borrowBook(@RequestParam("bookId") int bookId,
                             @RequestParam("id") int id){

        int result=recordService.borrowBook(bookId,id);
        if(result==0) return"success!";
        else if(result==1){return "The book has been booked!";
        }
        else return "The book has been lent out.";
    }

    @GetMapping("/getRecordByUserId")
    @ResponseBody
    public JSONObject getRecordByUserId(@RequestParam("userId")int userId){
        return recordService.getRecordByUserId(userId);
    }

    @PostMapping("/returnBook")
    @ResponseBody
    public String returnBook(@RequestParam("recordId") int recordId){
             recordService.returnBook(recordId);
             return "success!";
    }

    @GetMapping("/getRecordByTele")
    @ResponseBody
    public JSONObject getRecordByTele(@RequestParam("tele")String tele){
        return recordService.getRecordBytele(tele);
    }


}
