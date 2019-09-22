package com.it.springbootdemo.model;

public class Book {
    private int BookId;
    private String ISBN;
    private String price;
    private String location;
    private String bookname;
    private String author;
    private String press;
    public Book(int BookId,String ISBN,String price,String location,String bookname,String author,String press)
    {
        this.BookId=BookId;
        this.ISBN=ISBN;
        this.price=price;
        this.location=location;
        this.bookname=bookname;
        this.author=author;
        this.press=press;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
