package com.it.springbootdemo.mapper;


import com.it.springbootdemo.model.News;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper {

    @Select("select * from news limit 10")
    List<News> getNews();

    @Insert("insert into news(title,content) values (#{title},#{content})")
    void addNews(@Param("title") String title,@Param("content") String content);

    @Delete("delete from news where newsId=#{newsId}")
    void deleteNews(@Param("newsId") String newsId);

    @Update("update news set title=#{title}, content=#{content} where newsId=#{newsId}")
    void editNews(@Param("newsId") String newsId,@Param("title") String title,@Param("content") String content);
}
