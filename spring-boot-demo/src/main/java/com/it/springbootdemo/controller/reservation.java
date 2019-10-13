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
    public int addReservation(@RequestParam("userId") int userId,
                              @RequestParam("bookId") int bookId){
        return reservationService.addReservation(userId,bookId);
    }

}
