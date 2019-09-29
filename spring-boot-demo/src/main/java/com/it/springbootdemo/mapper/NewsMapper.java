package com.it.springbootdemo.mapper;


import com.it.springbootdemo.model.News;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper {

    @Select("select * from news limit 10")
    List<News> getNews();

    @Insert("insert into news(title,content) values (#{title},#{content})")
    void addNews(@Param("title") String title,@Param("content") String content);
}
