package com.it.springbootdemo.service.service_impl;


import com.it.springbootdemo.mapper.NewsMapper;
import com.it.springbootdemo.model.News;
import com.it.springbootdemo.service.NewsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;
    @Override
    public JSONObject getNews() {
        JSONObject ans=new JSONObject();
        JSONArray jsonObject = new JSONArray();
        List<News> news=newsMapper.getNews();
        for(News news1:news)
        {
            JSONObject result=new JSONObject();
            result.put("newsId",news1.getNewsId());
            result.put("title",news1.getTitle());
            result.put("content",news1.getContent());
            jsonObject.add(result);
        }
        ans.put("result",jsonObject);
        return ans;
    }

    @Override
    public int addNews(String title, String content) {
        newsMapper.addNews(title,content);
        return 1;
    }

    @Override
    public int deleteNews(String newsId) {
        newsMapper.deleteNews(newsId);
        return 1;
    }
}
