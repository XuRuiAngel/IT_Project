package com.it.springbootdemo.service.service_impl;

import com.it.springbootdemo.mapper.ReservationMapper;
import com.it.springbootdemo.model.Reservation;
import com.it.springbootdemo.service.RecordService;
import com.it.springbootdemo.service.ReservationService;
import com.it.springbootdemo.utils.TimeUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {


    @Autowired
    ReservationMapper  reservationMapper;
    @Override
    public int addReservation(int userId, int bookId) {
        int result=reservationMapper.getBookOrder(bookId);
        if(result==0){
        TimeUtil timeUtil = new TimeUtil();
        String nowdate= timeUtil.getFormatDateForFive();
        reservationMapper.updateOrder(1,bookId);
         reservationMapper.addReservation(userId,bookId,nowdate);
            return 1;
        }
        else return 0;

    }

    @Override
    public void deleteReservation() {
        List<Reservation> reservations=null;
        reservations=reservationMapper.getAllReservation();
        for(Reservation reservation:reservations){
            String bdate=reservation.getReserveTime();
            TimeUtil timeUtil = new TimeUtil();
            String nowdate= timeUtil.getFormatDateForFive();
            int btime=((int)bdate.charAt(11)-(int)('0'))*10+((int)bdate.charAt(12)-(int)('0'));
            int ntime=((int)nowdate.charAt(11)-(int)('0'))*10+((int)nowdate.charAt(12)-(int)('0'));
            if((ntime-btime)>=2){
                reservationMapper.deleteReservation(reservation.getID());
            }
            else continue;
        }
    }
}
