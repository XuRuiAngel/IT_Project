package com.it.springbootdemo.model;

public class BookLocation {
    private int locationID;
    private int FloorNo;
    private int ShelfNo;

    public BookLocation(int locationID,int FloorNo,int ShelfNo){
        this.locationID=locationID;
        this.FloorNo=FloorNo;
        this.ShelfNo=ShelfNo;
    }

    public int getLocationID() {
        return locationID;
    }
    public int getFloorNo(){
        return  this.FloorNo;
    }

    public int getShelfNo() {
        return ShelfNo;
    }
}
