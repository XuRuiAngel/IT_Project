package com.it.springbootdemo.controller;


import com.it.springbootdemo.service.NewsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class news {

    @Autowired
    NewsService newsService;

    @GetMapping("/getNews")
    @ResponseBody
    public JSONObject getNews(){
        return newsService.getNews();
    }

    @GetMapping("/addNews")
    @ResponseBody
    public String addNews(@RequestParam("title") String title,
                    @RequestParam("content") String content){
        newsService.addNews(title,content);
        return "success!";
    }
}
