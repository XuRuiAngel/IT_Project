package com.it.springbootdemo.model;

import javax.lang.model.element.NestingKind;

public class News {

    private String ISBN;
    private String title;
    private String content;

    public News(String ISBN, String title, String content) {
        this.ISBN = ISBN;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
