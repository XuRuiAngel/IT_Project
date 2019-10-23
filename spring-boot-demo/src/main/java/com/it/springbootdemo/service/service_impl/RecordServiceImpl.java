package com.it.springbootdemo.service.service_impl;

import com.it.springbootdemo.controller.record;
import com.it.springbootdemo.mapper.RecordMapper;
import com.it.springbootdemo.model.Record;
import com.it.springbootdemo.service.RecordService;
import com.it.springbootdemo.utils.EmailUtils;
import com.it.springbootdemo.utils.TimeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;


    @Override
    public int borrowBook(int bookId, int id) {

        int result=recordMapper.getBookOrder(bookId);

        if(result==0){
        TimeUtil timeUtil = new TimeUtil();
        String nowdate= timeUtil.getFormatDateForFive();
        recordMapper.updateOrder(2,bookId);
        recordMapper.borrowBook(bookId,id,nowdate);
        return 0;}
        else if(result==1){
            if(id==recordMapper.getUserId(bookId)){
                TimeUtil timeUtil = new TimeUtil();
                String nowdate= timeUtil.getFormatDateForFive();
                recordMapper.updateOrder(2,bookId);
                recordMapper.borrowBook(bookId,id,nowdate);
                return 0;
            }
            else return 1;
        }
        else return 2;

    }

    @Override
    public int returnBook(int recordId) {
        double  fine=recordMapper.getFine();
        double perid=recordMapper.getPeriod();
        double allFine;
        int num;
        String borrowTime=recordMapper.getBorrowTime(recordId);
        TimeUtil timeUtil = new TimeUtil();
        String nowdate= timeUtil.getFormatDateForFive();
        int bMonth=((int)borrowTime.charAt(5)-(int)('0'))*10+((int)borrowTime.charAt(6)-(int)('0'));
        int rMonth=((int)nowdate.charAt(5)-(int)('0'))*10+((int)nowdate.charAt(6)-(int)('0'));
        int month;
        if(rMonth>=bMonth){
            month=rMonth-bMonth;
        }
        else month=rMonth+12-bMonth;
        num=30*month;
        int bDay=((int)borrowTime.charAt(8)-(int)('0'))*10+((int)borrowTime.charAt(9)-(int)('0'));
        int rDay=((int)nowdate.charAt(8)-(int)('0'))*10+((int)nowdate.charAt(9)-(int)('0'));
        int day;
        if(rDay>=bDay) day=rDay-bDay;
        else {num-=30;
             day=rDay+30-bDay;}
        num+=day;
        if(num<=perid) allFine=0;
        else {
            allFine=(num-perid)*fine;
        }
        int bookId=recordMapper.getBookId(recordId);
        recordMapper.updateOrder(0,bookId);
        recordMapper.returnBook(recordId,nowdate,allFine);
        return 0;
    }

    @Override
    public JSONObject getRecordByUserId(int userId) {
        List<Record> records=null;
        records=recordMapper.getRecordByUserId(userId);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        for(Record record:records){
            JSONObject result=new JSONObject();
            result.put("recordId",record.getRecordId());
            result.put("userId",record.getUserId());
            result.put("bookId",record.getBookId());
            result.put("borrowTime",record.getBorrowTime());
            result.put("returnTime",record.getReturnTime());
            result.put("fine",record.getFine());
            result.put("flag",record.getFlag());
            jsonArray.add(result);

        }
        jsonObject.put("result",jsonArray);

        return jsonObject;
    }

    @Override
    public JSONObject getRecordBytele(String tele) {

        int userId=recordMapper.getUserIdBytele(tele);
        List<Record> records=null;
        records=recordMapper.getRecordByUserId(userId);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        for(Record record:records){
            JSONObject result=new JSONObject();
            result.put("recordId",record.getRecordId());
            result.put("userId",record.getUserId());
            result.put("bookId",record.getBookId());
            result.put("borrowTime",record.getBorrowTime());
            result.put("returnTime",record.getReturnTime());
            result.put("fine",record.getFine());
            result.put("flag",record.getFlag());
            jsonArray.add(result);

        }
        jsonObject.put("result",jsonArray);

        return jsonObject;
    }

    @Override
    public JSONObject getRecord() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<Record> records=null;
        records=recordMapper.getRecord();
        for(Record record:records){
            JSONObject result=new JSONObject();
            result.put("recordId",record.getRecordId());
            result.put("userId",record.getUserId());
            result.put("bookId",record.getBookId());
            result.put("borrowTime",record.getBorrowTime());
            result.put("returnTime",record.getReturnTime());
            result.put("fine",record.getFine());
            result.put("flag",record.getFlag());
            jsonArray.add(result);
        }
        jsonObject.put("result",jsonArray);

        return jsonObject;
    }

    @Override
    public int payFine(int recordId) {
        int flag=recordMapper.getFlag(recordId);
        if(flag==1) return 2;
        int userId=recordMapper.getUserIdByRecordId(recordId);
        double balance=recordMapper.getBalance(userId);
        double fine=recordMapper.getFineByRecordId(recordId);
        if(fine<=balance)
        {
            recordMapper.payFine(recordId);
            recordMapper.changeBalance(userId,balance-fine);
            return 1;
        }
        else {
            return 0;
        }


    }

    @Override
    public void tipEmail() {
        List<Record> records=null;
        records=recordMapper.getRecord();
        for(Record record:records)
        {

            int recordId=record.getRecordId();
            recordMapper
            double perid=recordMapper.getPeriod();
            int num;
            String borrowTime=recordMapper.getBorrowTime(recordId);
            TimeUtil timeUtil = new TimeUtil();
            String nowdate= timeUtil.getFormatDateForFive();
            int bMonth=((int)borrowTime.charAt(5)-(int)('0'))*10+((int)borrowTime.charAt(6)-(int)('0'));
            int rMonth=((int)nowdate.charAt(5)-(int)('0'))*10+((int)nowdate.charAt(6)-(int)('0'));
            int month;
            if(rMonth>=bMonth){
                month=rMonth-bMonth;
            }
            else month=rMonth+12-bMonth;
            num=30*month;
            int bDay=((int)borrowTime.charAt(8)-(int)('0'))*10+((int)borrowTime.charAt(9)-(int)('0'));
            int rDay=((int)nowdate.charAt(8)-(int)('0'))*10+((int)nowdate.charAt(9)-(int)('0'));
            int day;
            if(rDay>=bDay) day=rDay-bDay;
            else {num-=30;
                day=rDay+30-bDay;}
            num+=day;
            if((num-perid)<=2){
                String e_mail=recordMapper.getEmail(recordMapper.getUserIdByRecordId(recordId));
                String bookName=recordMapper.getBookName(recordMapper.getBookId(recordId));
                String content=bookName+"\nThe book you borrowed is about to expire. Please remember to return it in time to avoid any penalty.";
                EmailUtils.sendEmail("Tips for book expiration.", e_mail, null, "<h3>"+content+"</h3>", null);
            }
        }
    }
}
