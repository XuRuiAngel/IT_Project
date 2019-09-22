package com.it.springbootdemo.model;

public class Book {
    private int BookId;
    private String ISBN;
    private String price;
    private String location;
    private String bookName;
    private String author;
    private String press;
    private String description;
    private String publishYear;
    private String textLanguage;
    private int copyNumbers;

    public Book(int bookId, String ISBN, String price, String location, String bookname, String author,
                String press, String description, String publishYear, String textLanguage, int copyNumbers) {
        this.BookId = bookId;
        this.ISBN = ISBN;
        this.price = price;
        this.location = location;
        this.bookName = bookname;
        this.author = author;
        this.press = press;
        this.description = description;
        this.publishYear = publishYear;
        this.textLanguage = textLanguage;
        this.copyNumbers = copyNumbers;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookId=" + BookId +
                ", ISBN='" + ISBN + '\'' +
                ", price='" + price + '\'' +
                ", location='" + location + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", description='" + description + '\'' +
                ", publishYear='" + publishYear + '\'' +
                ", textLanguage='" + textLanguage + '\'' +
                ", copyNumbers=" + copyNumbers +
                '}';
    }
}
