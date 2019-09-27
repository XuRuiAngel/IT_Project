package com.it.springbootdemo.service;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface NewsService {

    public JSONObject getNews();

    public int addNews(String title,String content);

}
