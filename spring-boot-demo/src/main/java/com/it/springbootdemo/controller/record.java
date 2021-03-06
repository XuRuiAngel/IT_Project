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

    @PostMapping("/returnBookByBookId")
    @ResponseBody
    public String returnBookByBookId(@RequestParam("bookId") int bookId){
        int recordId=recordService.getRecordIdByBookId(bookId);
        recordService.returnBook(recordId);
        return "success!";
    }



    @GetMapping("/getRecordByTele")
    @ResponseBody
    public JSONObject getRecordByTele(@RequestParam("tele")String tele){
        return recordService.getRecordBytele(tele);
    }


    @GetMapping("/getRecord")
    @ResponseBody
    public JSONObject getRecord(){
        return recordService.getRecord();

    }

    @PostMapping("/payFine")
    @ResponseBody
    public String payFine(@RequestParam("recordId") int recordId)
    {
        int result=recordService.payFine(recordId);
        if(result==0) return "Insufficient Balance";
        else if(result==1) return "success!";
        else return "Fine has been paid!";

    }

    @GetMapping("/tipEmail")
    @ResponseBody
    public void tipEmail(){
        recordService.tipEmail();
    }

}
