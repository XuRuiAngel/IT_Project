package com.it.springbootdemo.controller;

import com.it.springbootdemo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class reservation {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/addReservation")
    @ResponseBody
    public String addReservation(@RequestParam("userId") int userId,
                              @RequestParam("bookId") int bookId){
        int result= reservationService.addReservation(userId,bookId);
        if(result==1) return "success";
        else return "The book has been booked or lent. ";
    }

}
