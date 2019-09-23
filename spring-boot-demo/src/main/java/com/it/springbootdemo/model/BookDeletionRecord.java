package com.it.springbootdemo.model;

import java.util.Date;

public class BookDeletionRecord {

    private int BookId;
    private Date time;
    private int UserId;

    public BookDeletionRecord(int bookId, Date time, int userId) {
        this.BookId = bookId;
        this.time = time;
        this.UserId = userId;
    }

    public int getUserId() {
        return this.UserId;
    }

    public int getBookId() {
        return this.BookId;
    }

    public Date getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return "BookDeletionRecord{" +
                "BookId=" + BookId +
                ", time=" + time +
                ", UserId=" + UserId +
                '}';
    }
}