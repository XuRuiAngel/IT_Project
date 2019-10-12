package com.it.springbootdemo.model;

import java.util.Date;

public class Record {

    private int RecordId;
    private int UserId;
    private int BookId;
    private String BorrowTime;
    private String ReturnTime;
    private double fine;

    public Record(int recordId, int userId, int bookId, String borrowTime, String returnTime, double fine) {
        this.RecordId = recordId;
        this.UserId = userId;
        this.BookId = bookId;
        this.BorrowTime = borrowTime;
        this.ReturnTime = returnTime;
        this.fine = fine;
    }

    public Record( int userId, int bookId, String borrowTime, String returnTime, double fine) {

        this.UserId = userId;
        this.BookId = bookId;
        this.BorrowTime = borrowTime;
        this.ReturnTime = returnTime;
        this.fine = fine;
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
