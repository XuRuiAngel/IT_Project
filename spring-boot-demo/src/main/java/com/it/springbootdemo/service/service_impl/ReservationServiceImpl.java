package com.it.springbootdemo.service.service_impl;

import com.it.springbootdemo.mapper.ReservationMapper;
import com.it.springbootdemo.service.RecordService;
import com.it.springbootdemo.service.ReservationService;
import com.it.springbootdemo.utils.TimeUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {


    @Autowired
    ReservationMapper  reservationMapper;
    @Override
    public int addReservation(int userId, int bookId) {
        TimeUtil timeUtil = new TimeUtil();
        String nowdate= timeUtil.getFormatDateForFive();
         reservationMapper.addReservation(userId,bookId,nowdate);
         return 1;
    }
}
