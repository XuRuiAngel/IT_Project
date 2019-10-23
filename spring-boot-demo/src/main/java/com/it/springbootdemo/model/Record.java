package com.it.springbootdemo.model;

import java.util.Date;

public class Record {

    private int RecordId;
    private int UserId;
    private int BookId;
    private String BorrowTime;
    private String ReturnTime;
    private double fine;
    public int flag;

    public Record(int recordId, int userId, int bookId, String borrowTime, String returnTime, double fine,int flag) {
        this.RecordId = recordId;
        this.UserId = userId;
        this.BookId = bookId;
        this.BorrowTime = borrowTime;
        this.ReturnTime = returnTime;
        this.fine = fine;
        this.flag=flag;
    }

    public Record( int userId, int bookId, String borrowTime, String returnTime, double fine,int flag) {

        this.UserId = userId;
        this.BookId = bookId;
        this.BorrowTime = borrowTime;
        this.ReturnTime = returnTime;
        this.fine = fine;
        this.flag=flag;
    }

    

    public String getBorrowTime() {
        return this.BorrowTime;
    }

    public String getReturnTime() {
        return this.ReturnTime;
    }

    public double getFine() {
        return this.fine;
    }

    public int getBookId() {
        return this.BookId;
    }

    public int getRecordId() {
        return this.RecordId;
    }

    public int getUserId() {
        return this.UserId;
    }

    public int getFlag(){
        return this.flag;
    }

    @Override
    public String toString() {
        return "Record{" +
                "RecordId=" + RecordId +
                ", UserId=" + UserId +
                ", BookId=" + BookId +
                ", BorrowTime=" + BorrowTime +
                ", ReturnTime=" + ReturnTime +
                ", fine=" + fine +
                '}';
    }
}
