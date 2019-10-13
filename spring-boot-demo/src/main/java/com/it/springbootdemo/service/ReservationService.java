package com.it.springbootdemo.service;


import org.springframework.stereotype.Service;

@Service
public interface ReservationService {
    public int addReservation(int userId,int bookId);

    public void deleteReservation();
}
