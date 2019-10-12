package com.it.springbootdemo.service.service_impl;

import com.it.springbootdemo.mapper.BookMapper;
import com.it.springbootdemo.mapper.RecordMapper;
import com.it.springbootdemo.service.RecordService;
import com.it.springbootdemo.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;
    BookMapper bookMapper;

    @Override
    public int borrowBook(int bookId, int id) {
        int result=0;

        if(result==0){
        TimeUtil timeUtil = new TimeUtil();
        String nowdate= timeUtil.getFormatDateForFive();
        recordMapper.borrowBook(bookId,id,nowdate);
        return 0;}
        else if(result==1){
            return 1;
        }
        else return 2;

    }
}
