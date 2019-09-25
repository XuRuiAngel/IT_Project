package com.it.springbootdemo.mapper;


import com.it.springbootdemo.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    @Select("select * from book where ${key}=#{text}")
    List<Book>  searchBook(@Param("key") String key,@Param("text") String text);
}
