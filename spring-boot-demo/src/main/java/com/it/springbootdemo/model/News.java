package com.it.springbootdemo.model;

import javax.lang.model.element.NestingKind;

public class News {

    private int newsId;
    private String title;
    private String content;

    public News(int newsId, String title, String content) {
        this.newsId = newsId;
        this.title = title;
        this.content = content;
    }

    public News( String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getNewsId() {
        return this.newsId;
    }

    public String getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "News{" +
                "ISBN='" + newsId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
