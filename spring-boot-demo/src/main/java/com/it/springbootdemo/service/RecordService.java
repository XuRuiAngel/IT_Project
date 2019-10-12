package com.it.springbootdemo.service;


import org.springframework.stereotype.Service;

@Service
public interface RecordService {

    public int borrowBook(int bookId,int id);
}
