package com.it.springbootdemo.model;

import org.hibernate.validator.constraints.ISBN;

public class BookCatagory {
    private int categoryID;
    private String TypeName;
    public BookCatagory(int categoryID,String TypeName)
    {
        this.categoryID=categoryID;
        this.TypeName=TypeName;
    }

    public int getCategoryID() {
        return this.categoryID;
    }

    public String getTypeName() {
        return this.TypeName;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
