package com.it.springbootdemo.model;

import org.hibernate.validator.constraints.ISBN;

public class BookCatagory {
    private String ISBN;
    private String TypeName;
    public BookCatagory(String ISBN,String TypeName)
    {
        this.ISBN=ISBN;
        this.TypeName=TypeName;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getTypeName() {
        return this.TypeName;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
