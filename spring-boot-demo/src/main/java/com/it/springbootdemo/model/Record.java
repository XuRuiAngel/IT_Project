package com.it.springbootdemo.model;

import java.util.Date;

public class Record {

    private int RecordId;
    private int UserId;
    private int BookId;
    private Date BorrowTime;
    private Date ReturnTime;
    private double fine;

    public Record(int recordId, int userId, int bookId, Date borrowTime, Date returnTime, double fine) {
        this.RecordId = recordId;
        this.UserId = userId;
        this.BookId = bookId;
        this.BorrowTime = borrowTime;
        this.ReturnTime = returnTime;
        this.fine = fine;
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
