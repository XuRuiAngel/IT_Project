package com.it.springbootdemo.model;

import java.util.Date;

public class BookDeletionRecord {

    private int BookId;
    private String time;
    private int UserId;
    private String reason;

    public BookDeletionRecord(int bookId,int userId,String time,String reason) {
        this.BookId = bookId;
        this.time = time;
        this.UserId = userId;
        this.reason=reason;
    }

    public int getUserId() {
        return this.UserId;
    }

    public int getBookId() {
        return this.BookId;
    }

    public String getTime() {
        return this.time;
    }

    public String getReason(){return this.reason;}

    @Override
    public String toString() {
        return "BookDeletionRecord{" +
                "BookId=" + BookId +
                ", time=" + time +
                ", UserId=" + UserId +
                '}';
    }
}
