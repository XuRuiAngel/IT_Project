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

    public Book( String ISBN, String price, String location, String bookname, String author,
                String press, String description, String publishYear, String textLanguage, int copyNumbers) {
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

    public String getISBN() {
        return this.ISBN;
    }

    public int getBookId() {
        return this.BookId;
    }

    public int getCopyNumbers() {
        return this.copyNumbers;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLocation() {
        return this.location;
    }

    public String getPress() {
        return this.press;
    }

    public String getPrice() {
        return this.price;
    }

    public String getPublishYear() {
        return this.publishYear;
    }

    public String getTextLanguage() {
        return this.textLanguage;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setCopyNumbers(int copyNumbers) {
        this.copyNumbers = copyNumbers;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public void setTextLanguage(String textLanguage) {
        this.textLanguage = textLanguage;
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
