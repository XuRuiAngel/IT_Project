package com.it.springbootdemo.model;

import java.util.Date;

public class Reservation {

    private int ID;
    private int userId;
    private int bookId;
    private String reserveTime;

    public Reservation(int ID, int userId, int bookId, String reserveTime) {
        this.ID = ID;
        this.userId = userId;
        this.bookId = bookId;
        this.reserveTime = reserveTime;
    }

    public String getReserveTime() {
        return this.reserveTime;
    }

    public int getUserId() { return this.userId; }

    public int getBookId() {
        return this.bookId;
    }

    public int getID() {
        return this.ID;
    }


}
